Greenwood Event Portal - JavaScript Solutions
==============================================

Welcome! This is the complete solution for the JavaScript exercises in Module 1 - JavaScript.
The application demonstrates the implementation of fundamental and modern JavaScript techniques by adding dynamic behavior to a Greenwood Community Event Portal.

---------------------------------------------------------
1. PROJECT STRUCTURE
---------------------------------------------------------
Module 1 - JavaScript Solutions/
│
├── index.html          - Main portal interface with dynamic filters & dynamic event card grids
├── styles.css          - Styling for cards, search elements, forms, and loading animations
├── main.js             - Main logic file containing constructions, state, rendering, and API fetch
├── data/
│   └── events.json     - Mock database containing event items (JSON array)
├── pages/
│   └── register.html   - RSVP registration page with form validations and API submission simulation
└── README.txt          - Project guide and framework discussion

---------------------------------------------------------
2. HOW TO RUN THE PROJECT
---------------------------------------------------------
1. Open the project folder on your computer.
2. Open the "index.html" file in any modern web browser (e.g., Chrome, Edge, Safari, Firefox).
3. Important Note on JSON Fetching:
   Browsers block local file system (file://) fetch calls by default due to CORS security policies. 
   To run the async JSON fetching correctly:
   a. Open the folder in VS Code.
   b. Install the "Live Server" extension.
   c. Click "Go Live" at the bottom right of VS Code to open the app on http://127.0.5.1:5500.
   d. Alternatively, run a local Python server in the project directory using:
      `python -m http.server 8000`
      Then browse to `http://localhost:8000`.

---------------------------------------------------------
3. JAVASCRIPT CONCEPTS DEMONSTRATED
---------------------------------------------------------
Here is a list of the exercises from the PDF and where they are implemented:

* Task 1: Setup & Alert
  - linked main.js at the head using "<script src="main.js" defer></script>".
  - Logs "Welcome to the Community Portal" immediately in the console.
  - Fires an alert("Welcome! The Greenwood Community Portal is fully loaded.") on page load.

* Task 2: Syntax, Data Types & Operators
  - Declares variables using let and const throughout main.js and register.html.
  - Uses template literals (e.g., `[${event.category}] ${event.name}`) for display titles.
  - Decrements seat count using "event.seats--" upon event registration.

* Task 3: Conditionals, Loops & Error Handling
  - Loop and render events using eventsList.forEach().
  - Wraps event registration logic in try-catch blocks to catch out-of-seat scenarios.
  - Hides loading spinner and configures DOM style display properties.

* Task 4: Functions & Closures
  - Created modular functions: loadEventsData(), renderEventCards(), handleEventRegistration().
  - High-Order Function filterEventsList(events, callback) handles dynamic lists.
  - Private state closure tracker created via createCategoryRegistrationTracker() to track and log total user registrations per category.

* Task 5: Objects & Prototypes
  - Defined Event constructor CommunityEvent(id, name, category, date, seats, description, image).
  - Attached checkAvailability() to CommunityEvent.prototype.
  - Prints metadata using Object.entries(eventsList[0]) in the console.

* Task 6: Array Methods
  - Appends items dynamically using array.push().
  - Uses .map() to format card titles by prefixing their categories.
  - Uses .filter() to filter search results by categories and keyword input.
  - Clones list using spread operator [...eventsList] before filtering.

* Task 7: DOM Manipulation
  - Selected nodes using querySelector().
  - Instantiates event cards dynamically using document.createElement() and appends them via appendChild().
  - Automatically updates seat status, buttons, and global counters in the UI on click.

* Task 8: Event Handling
  - Register buttons trigger inline onclick events.
  - Search input fields monitor onkeydown and onchange events to trigger search filters on each keystroke.

* Task 9: Async JS, Promises & Async/Await
  - Initially calls fetchEventsWithPromises() showing .then().catch() promise flows.
  - Loads data using async function loadEventsData() which displays a loading spinner and simulates network latency before rendering cards.

* Task 10: ES6 Features
  - Destructures properties from event object: const { id, name, category, ... } = event;
  - Clones elements using the spread operator.
  - Uses default parameters in functions.

* Task 11: Form Handling (pages/register.html)
  - Captures inputs on submit using form.elements.
  - Prevents page reload using event.preventDefault().
  - Validates name length, email patterns (regex matching), event choice, and check agreements.

* Task 12: AJAX & Fetch POST
  - POSTs RSVP records to "https://jsonplaceholder.typicode.com/posts" via fetch().
  - Utilizes setTimeout() to simulate loading states before processing submissions.
  - Renders inline error/success notifications.

* Task 13: Debugging
  - Inspect variables and console logs by pressing F12 in your browser and selecting the "Console" tab.
  - The console logs: registration steps, keystrokes, filter states, API status, and payload details.

* Task 14: jQuery & Frameworks
  - Links jQuery CDN in index.html head.
  - Button click handler: $("#toggleIntroBtn").click() toggles the description box.
  - Card animations: $("#eventsGrid").fadeOut() and fadeIn() are used when changing filter selectors.
  
  Benefits of Frameworks (e.g., React or Vue) vs Vanilla JS & jQuery:
  In this project, we manually update the DOM when seats change (re-creating cards or manually changing selectors). In frameworks:
  1. Declarative UI (Reactive State): Frameworks manage state reactively. We would update seats in the state, and the UI would automatically re-render the affected element without manual document.createElement or jQuery selections.
  2. Component Reusability: Cards can be written as self-contained components (e.g. <EventCard key={id} {...event} />) containing their own styles and logic, rather than long string templates.
  3. Virtual DOM / Performance: Frameworks optimize DOM updates, only changing changed text nodes rather than deleting and replacing entire grid elements.
