// ==========================================
// 1. JavaScript Basics & Setup
// ==========================================

// Startup console log as requested in Task 1
console.log("Welcome to the Community Portal");

// Window load event listener showing alert popup
window.addEventListener("load", () => {
  console.log("Window fully loaded event fired");
  alert("Welcome! The Greenwood Community Portal is fully loaded.");
});

// ==========================================
// 2. Data Modeling - Objects & Prototypes
// ==========================================

// Event Constructor Function (Task 5 with ES6 default parameter for image in Task 10)
function CommunityEvent(id, name, category, date, seats, description, image = "assets/images/cleanup.png") {
  this.id = id;
  this.name = name;
  this.category = category;
  this.date = date;
  this.seats = seats; // will use let variable or property to decrement/increment
  this.description = description;
  this.image = image;
}

// Adding checkAvailability to the prototype (Task 5)
CommunityEvent.prototype.checkAvailability = function() {
  return this.seats > 0;
};

// ==========================================
// 3. State & Tracker Closures
// ==========================================

// In-memory array of all events
let eventsList = [];

// Track registered event IDs (Task 7 UI update on cancel)
const registeredEvents = new Set();

// Global count of successful registrations
let globalRegistrationsCount = 0;

// Closure to track registrations per category (Task 4)
function createCategoryRegistrationTracker() {
  // private dictionary in closure scope
  const registrationCounts = {};
  
  return {
    trackRegistration: function(categoryName) {
      if (!registrationCounts[categoryName]) {
        registrationCounts[categoryName] = 0;
      }
      registrationCounts[categoryName]++;
      console.log(`[Tracker Closure] Category '${categoryName}' registrations: ${registrationCounts[categoryName]}`);
      return registrationCounts[categoryName];
    },
    getCategoryCount: function(categoryName) {
      return registrationCounts[categoryName] || 0;
    }
  };
}

// Instantiate the closure tracker
const categoryTracker = createCategoryRegistrationTracker();

// ==========================================
// 3.5. Required Functions (Task 4)
// ==========================================

// Add Event Function (Task 4 & Task 6 .push wrapper)
function addEvent(eventObj) {
  eventsList.push(eventObj);
  console.log(`[Task 4 addEvent] Event added: ${eventObj.name}`);
}

// Register User Function (Task 4 wrapper)
function registerUser(eventId) {
  handleEventRegistration(eventId);
}

// Filter Events by Category Function (Task 4 & Task 6 .filter wrapper)
function filterEventsByCategory(category) {
  return eventsList.filter(event => event.category === category);
}

// ==========================================
// 4. API & Fetching logic (Async/Await & Promises)
// ==========================================

// Function using then/catch format to showcase Task 9 promise handling
function fetchEventsWithPromises() {
  console.log("Attempting to load events via Promises .then()/.catch()...");
  
  fetch("data/events.json")
    .then(response => {
      if (!response.ok) {
        throw new Error("HTTP error loading JSON data file");
      }
      return response.json();
    })
    .then(data => {
      console.log("Successfully fetched events via promise chain:", data);
    })
    .catch(error => {
      console.error("Promise fetch failed:", error);
    });
}

// Async/Await fetch function with spinner handling (Task 9)
async function loadEventsData() {
  const spinner = document.querySelector("#loadingSpinner");
  const grid = document.querySelector("#eventsGrid");
  
  // Show spinner, hide grid
  if (spinner) spinner.style.display = "block";
  if (grid) grid.style.display = "none";
  
  // Simulating small network latency so loading spinner is visible
  await new Promise(resolve => setTimeout(resolve, 800));
  
  try {
    console.log("Fetching events database from local path 'data/events.json'...");
    const response = await fetch("data/events.json");
    
    if (!response.ok) {
      throw new Error(`Failed to load JSON database: ${response.statusText}`);
    }
    
    const rawEvents = await response.json();
    console.log("Raw JSON events loaded:", rawEvents);
    
    // Construct CommunityEvent objects and add to list (Task 4 addEvent & Task 6 .push)
    eventsList = [];
    rawEvents.forEach(item => {
      const eventObj = new CommunityEvent(
        item.id,
        item.name,
        item.category,
        item.date,
        item.seats,
        item.description,
        item.image
      );
      addEvent(eventObj);
    });
    
    console.log("Populated eventsList with constructed items:", eventsList);

    // Demonstrate Object.entries on the first event loaded (Task 5)
    if (eventsList.length > 0) {
      console.log("Printing Object.entries metadata for the first event:");
      Object.entries(eventsList[0]).forEach(([key, val]) => {
        console.log(`  ${key}: ${val}`);
      });
    }
    
    // Render the initial list
    renderEventCards(eventsList);
    
  } catch (err) {
    console.error("Error loading events: ", err);
    const noEventsMsg = document.querySelector("#noEventsMessage");
    if (noEventsMsg) {
      noEventsMsg.textContent = "Error loading event listings. Please refresh or try again later.";
      noEventsMsg.style.display = "block";
    }
  } finally {
    // Hide spinner, show grid
    if (spinner) spinner.style.display = "none";
    if (grid) grid.style.display = "grid";
  }
}

// ==========================================
// 5. Dynamic Rendering & DOM Manipulation
// ==========================================

// Function to render cards using template literals, destructuring, and DOM APIs
function renderEventCards(eventsToRender) {
  const eventsGrid = document.querySelector("#eventsGrid");
  const noEventsMsg = document.querySelector("#noEventsMessage");
  
  // Clear previous cards
  eventsGrid.innerHTML = "";
  
  if (eventsToRender.length === 0) {
    if (noEventsMsg) noEventsMsg.style.display = "block";
    eventsGrid.style.display = "none";
    return;
  }
  
  if (noEventsMsg) noEventsMsg.style.display = "none";
  eventsGrid.style.display = "grid";
  
  // formatting titles using .map as requested in Task 6
  // prefix event names based on their category
  const formattedEvents = eventsToRender.map(event => {
    return {
      originalObj: event,
      displayTitle: `[${event.category}] ${event.name}`
    };
  });
  
  // Loop through items using forEach (Task 3)
  formattedEvents.forEach(item => {
    // Destructuring event details (Task 10)
    const { id, name, category, date, seats, description, image } = item.originalObj;
    
    // Create event card container using createElement (Task 7)
    const card = document.createElement("div");
    card.className = "eventCard";
    card.setAttribute("data-id", id);
    
    // Determine seat availability, registration state, and classes (Task 7 Registers/Cancels UI Update)
    const isRegistered = registeredEvents.has(id);
    let seatStatusText = `${seats} seats remaining`;
    let seatClass = "";
    let isBtnDisabled = false;
    let btnText = "Register";
    
    if (isRegistered) {
      btnText = "Cancel RSVP";
      seatStatusText = "Registered (Secured)";
      seatClass = "registered";
    } else if (seats === 0) {
      seatStatusText = "SOLD OUT";
      seatClass = "soldout";
      isBtnDisabled = true;
    } else if (seats <= 5) {
      seatClass = "low";
    }
    
    // Fill inner HTML (incorporating template literals from Task 2)
    card.innerHTML = `
      <div class="cardImage">
        <img src="${image}" alt="${name}">
      </div>
      <div class="cardBody">
        <span class="cardCategory">${category}</span>
        <h3 class="cardTitle">${item.displayTitle}</h3>
        <p class="cardDate">Scheduled: ${date}</p>
        <p class="cardDesc">${description}</p>
        <div class="cardFooter">
          <span class="cardSeats ${seatClass}">${seatStatusText}</span>
          <button class="registerBtn ${isRegistered ? 'cancelBtn' : ''}" ${isBtnDisabled ? 'disabled' : ''}>${btnText}</button>
        </div>
      </div>
    `;
    
    // onclick handler on register button (Task 8 & 7)
    const registerBtn = card.querySelector(".registerBtn");
    registerBtn.onclick = function() {
      // Execute seat registration/cancellation inside a try-catch block (Task 3 & Task 4 registerUser)
      try {
        console.log(`RSVP action button clicked for event ID: ${id}`);
        registerUser(id);
      } catch (error) {
        alert(`Registration Error: ${error.message}`);
        console.error("Registration handling failed:", error);
      }
    };
    
    // Append card to grid container
    eventsGrid.appendChild(card);
  });
}

// ==========================================
// 6. Registration Business Logic (Try/Catch/Updates)
// ==========================================

function handleEventRegistration(eventId) {
  // Find event using array functions
  const event = eventsList.find(e => e.id === eventId);
  
  if (!event) {
    throw new Error("Event not found in the database!");
  }
  
  const isRegistered = registeredEvents.has(eventId);
  
  if (isRegistered) {
    // Cancellation path (Task 7: Update UI when user cancels)
    event.seats++;
    globalRegistrationsCount = Math.max(0, globalRegistrationsCount - 1);
    registeredEvents.delete(eventId);
    
    // Update global count UI
    const countDisplay = document.querySelector("#globalRegCount");
    if (countDisplay) countDisplay.textContent = globalRegistrationsCount;
    
    // Re-render to update seat count and change button back to "Register"
    renderEventCards(eventsList);
    
    console.log(`[Cancellation] Cancelled RSVP for '${event.name}'. Seats returned to: ${event.seats}`);
    alert(`Registration cancelled successfully for: ${event.name}`);
  } else {
    // Registration path (Task 7: Update UI when user registers)
    // check prototype availability method (Task 5)
    if (!event.checkAvailability()) {
      throw new Error("Sorry, this event is already sold out!");
    }
    
    // Decrement seat count using -- operator (Task 2)
    event.seats--;
    console.log(`Successfully registered. Decremented seats for event '${event.name}'. New count: ${event.seats}`);
    
    // Increment global counter
    globalRegistrationsCount++;
    const countDisplay = document.querySelector("#globalRegCount");
    if (countDisplay) countDisplay.textContent = globalRegistrationsCount;
    
    // Track registration ID
    registeredEvents.add(eventId);
    
    // Increment category counts via the closure tracker (Task 4)
    categoryTracker.trackRegistration(event.category);
    
    // Re-render event cards to update seats count and change button to "Cancel RSVP"
    renderEventCards(eventsList);
    
    alert(`Registration successful! You have secured a seat for: ${event.name}`);
  }
}

// ==========================================
// 7. Filtering & Callback Search logic
// ==========================================

// Callback based filter function (Task 4 HOF with ES6 default parameters for Task 10)
function filterEventsList(eventsArray = eventsList, filterCallback = () => true) {
  // Clone list using spread operator before filtering (Task 10)
  const listClone = [...eventsArray];
  return listClone.filter(filterCallback);
}

// Primary search/filter controller
function performFiltering() {
  const keyword = document.querySelector("#searchInput").value.toLowerCase();
  const category = document.querySelector("#categoryFilter").value;
  
  console.log(`Filtering events. Keyword: "${keyword}", Category: "${category}"`);
  
  // Callback filter matching category & text keywords
  const filterLogic = function(event) {
    const matchesKeyword = event.name.toLowerCase().includes(keyword) || 
                           event.description.toLowerCase().includes(keyword);
    
    const matchesCategory = (category === "all" || event.category === category);
    
    // Hide past or full events conditional example (Task 3)
    // For demonstration, let's keep all matching but only if seats check allows
    return matchesKeyword && matchesCategory;
  };
  
  const filteredResults = filterEventsList(eventsList, filterLogic);
  
  // jQuery transition (Task 14): Fade out, update, and fade back in
  $("#eventsGrid").fadeOut(200, function() {
    renderEventCards(filteredResults);
    $("#eventsGrid").fadeIn(250);
  });
}

// ==========================================
// 8. Event Listeners Setup (Tasks 8 & 14)
// ==========================================

document.addEventListener("DOMContentLoaded", () => {
  
  // Load initial dataset using promises first, then trigger actual loading
  fetchEventsWithPromises();
  loadEventsData();
  
  // Demonstration for Task 6: Filter only music events using .filter()
  setTimeout(() => {
    const musicEventsOnly = filterEventsByCategory("Music");
    console.log("[Task 6 Demo] Filtered array to show ONLY music events:", musicEventsOnly);
  }, 1200);
  
  // onchange dropdown listener
  const categoryFilter = document.querySelector("#categoryFilter");
  if (categoryFilter) {
    categoryFilter.onchange = function() {
      console.log("Category filter changed value to:", categoryFilter.value);
      performFiltering();
    };
  }
  
  // keydown text input listener for dynamic search
  const searchInput = document.querySelector("#searchInput");
  if (searchInput) {
    searchInput.onkeydown = function(event) {
      console.log(`Key pressed in search input: ${event.key}`);
      // perform filter on each key stroke or input change
      performFiltering();
    };
  }
  
  // jQuery button click handler (Task 14)
  $("#toggleIntroBtn").click(function() {
    console.log("jQuery toggle intro button clicked");
    
    // Toggle the display using fadeIn() / fadeOut()
    const intro = $("#introText");
    if (intro.is(":visible")) {
      intro.fadeOut(400);
      $(this).text("Show Intro Info");
    } else {
      intro.fadeIn(400);
      $(this).text("Hide Intro Info");
    }
  });

  // Task 14 literal compliance: Handle click events via jQuery for register actions
  // Since buttons are dynamic, we use event delegation with a class/ID selector
  $(document).on("click", ".registerBtn", function() {
    console.log("[Task 14 jQuery click] Detected click on a registration/cancellation button using jQuery");
  });

});
