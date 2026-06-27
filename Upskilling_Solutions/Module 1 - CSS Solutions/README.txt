Greenwood Community Hub - Local Events Portal
==============================================

Welcome! This is the complete solution for the CSS exercises in Module 1 - CSS3.
The application demonstrates the implementation of basic to intermediate CSS techniques by styling a Greenwood Community Hub event website.

---------------------------------------------------------
1. PROJECT STRUCTURE
---------------------------------------------------------
Module 1 - CSS Solutions/
│
├── index.html          - Main website layout (includes inline & internal styles)
├── styles.css          - Primary desktop/base stylesheet (includes resets, variables, selectors, layout)
├── responsive.css      - Media query modifications for mobile and tablet styling
└── assets/
    └── images/         - Image assets for background, cleanup, market, and run events
        ├── bg-pattern.png
        ├── cleanup.png
        ├── market.png
        └── run.png

---------------------------------------------------------
2. HOW TO RUN THE PROJECT
---------------------------------------------------------
1. Open the project folder on your computer.
2. Locate the "index.html" file.
3. Double-click the "index.html" file (or right-click and choose "Open With" your web browser, e.g., Chrome, Edge, Safari).
4. The page will load immediately! No server or build process is required.

---------------------------------------------------------
3. CSS CONCEPTS IMPLEMENTED
---------------------------------------------------------
Here is a list of the exercises from the PDF and where they are implemented:

* Exercise 1: CSS Inclusion Methods
  - Inline CSS: Applied in index.html to the header tag h1 (making it red).
  - Internal CSS: Defined in the <style> block in index.html head to set the body's fallback background color.
  - External CSS: Moved all styles to styles.css and responsive.css and linked them in the head.

* Exercise 2: Syntax and Comments
  - All rules in styles.css are indented and spaced for readability.
  - Realistic junior-developer style comments label each section (e.g. /* Base Body Styles */, /* Event Cards Layout */).

* Exercise 3: Selectors Playground
  - Universal selector: Used "*" to reset margin, padding, and set box-sizing: border-box.
  - Element selector: Used "h2" to style all subheadings.
  - ID selector: Used "#mainHeader" to style the hero banner.
  - Class selector: Used ".eventCard" to style card containers.
  - Grouping selector: Used "h3, p" to style title and paragraph text together.

* Exercise 4: Color and Background
  - Used HEX colors (#2e7d32, #ffd54f, etc.) and RGBA colors for transparency (e.g., linear-gradient overlay).
  - Set a repeating background image "bg-pattern.png" on the body with a fallback solid color.
  - Styled headers using linear-gradient overlay.

* Exercise 5: Typography
  - Imported Google Font "Outfit" using @import in styles.css.
  - Custom settings for font-family, font-size, font-style, font-weight, text-transform, text-align, line-height, and letter-spacing across headers, dates, and text columns.

* Exercise 6: Link and List Styling
  - Nav menu items style links using :link, :visited, :hover, and :active pseudo-classes.
  - List bullets removed from the nav menu using "list-style-type: none", and list items are separated using margin-left.

* Exercise 7: Table Styling
  - Schedule table is styled with borders, padding, collapsed borders (border-collapse: collapse), and centered text (text-align: center).
  - Zebra striping applied using the "tbody tr:nth-child(even)" selector.

* Exercise 8: Box Model & Layout Control
  - Margins, borders, and padding are applied to ".eventCard" elements.
  - Input fields in the contact form show a custom border color and highlight outline on focus (input:focus).
  - A dedicated demonstration section visually highlights the difference between display: none and visibility: hidden:
    * display: none; -> Removes the element entirely from the layout flow. Surrounding items slide in to fill the gap.
    * visibility: hidden; -> Keeps the element, reserving its space in the page layout, but hides its visual output.

* Exercise 9: Multiple Columns in Text
  - The bulletin news section uses "column-count: 2", "column-gap: 30px", and "column-rule: 1px solid gray" to create a newspaper columns look.

* Exercise 10: Responsive Web Design & Media Queries
  - responsive.css contains a media query for "@media screen and (max-width: 768px)".
  - Stacks navigation items vertically.
  - Uses percentage (%), viewport width (vw), and viewport height (vh) for flexible scaling.
  - Cards adapt to vertical stacked columns on smaller viewports.

* Exercise 11: Testing with DevTools
  - To test responsiveness:
    1. Right-click anywhere on the webpage in Chrome/Edge and select "Inspect" to open Developer Tools.
    2. Click the "Toggle device toolbar" icon (phone and tablet icon at top-left of DevTools panel).
    3. Select different preset devices (e.g., iPhone, iPad) or drag the sides of the viewport to resize it manually.
    4. Observe how the top navigation stacks vertically, margins shrink, cards collapse, and columns collapse into a single column on mobile screen widths.
