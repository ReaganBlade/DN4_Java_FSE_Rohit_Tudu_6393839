### List the features of ES6

ES6 (ECMAScript 2015) introduced many powerful features that have become standard in modern JavaScript and React development. The most important ones include:

  * **`let` and `const`:** Block-scoped variable and constant declarations.
  * **Arrow Functions:** A more concise syntax for writing functions with a lexical `this`.
  * **Classes:** Syntactic sugar for creating constructor functions and handling inheritance.
  * **Template Literals:** An easier way to work with strings, allowing for embedded expressions and multi-line strings.
  * **Destructuring:** A syntax that allows you to unpack values from arrays or properties from objects into distinct variables.
  * **Default Parameters:** The ability to give default values to function parameters.
  * **Modules:** The `import` and `export` keywords for sharing code between different files.
  * **Promises:** A native way to handle asynchronous operations.
  * **`Set` and `Map`:** New data structures for handling unique values and key-value pairs.

-----

### Explain JavaScript let

`let` is a keyword used to declare a **block-scoped** variable. A block is any code enclosed in curly braces `{}`, like in an `if` statement or a `for` loop.

This means a variable declared with `let` is only accessible within the block it was defined in. Variables declared with `let` can be reassigned but cannot be re-declared in the same scope.

```javascript
function checkScope() {
  let x = 10;
  if (true) {
    let y = 20; // y is only accessible inside this if block
    console.log(x); // Outputs: 10
    console.log(y); // Outputs: 20
  }
  console.log(x); // Outputs: 10
  // console.log(y); // Throws ReferenceError: y is not defined
}
```

-----

### Identify the differences between var and let

`var` and `let` are both used for variable declaration, but they differ in two fundamental ways: **scope** and **hoisting**.

1.  **Scope**

      * **`var`** is **function-scoped**. It is accessible anywhere within the function it's declared in, regardless of block.
      * **`let`** is **block-scoped**. It is only accessible within the `{}` block it's declared in.

    <!-- end list -->

    ```javascript
    function scopeTest() {
      if (true) {
        var a = 'var is function-scoped';
        let b = 'let is block-scoped';
      }
      console.log(a); // Outputs: 'var is function-scoped'
      // console.log(b); // Throws ReferenceError because b is out of scope
    }
    ```

2.  **Hoisting**

      * **`var`** declarations are hoisted to the top of their scope and initialized with `undefined`. You can access them before the declaration without an error.
      * **`let`** declarations are also hoisted but are **not initialized**. Accessing a `let` variable before its declaration results in a `ReferenceError`. This is often called the "Temporal Dead Zone."

-----

### Explain JavaScript const

`const` is used to declare a **block-scoped** constant. Like `let`, it is only accessible within the `{}` block it's defined in.

The key characteristic of `const` is that once a value is assigned to it, it **cannot be reassigned**.

It's important to note that `const` does not make objects or arrays immutable. It only prevents the variable from being reassigned to a different object or array. You can still modify the properties of a `const` object or the elements of a `const` array.

```javascript
const PI = 3.14159;
// PI = 3.14; // Throws TypeError: Assignment to constant variable.

const person = { name: 'Alice' };
person.name = 'Bob'; // This is allowed.
console.log(person.name); // Outputs: 'Bob'

// person = { name: 'Charlie' }; // This is NOT allowed and throws a TypeError.
```

-----

### Explain ES6 class fundamentals

ES6 classes are a cleaner and more modern way to create objects and handle inheritance in JavaScript. They are "syntactic sugar" over the existing prototype-based inheritance, making the code easier to read and write for developers familiar with object-oriented programming.

Key fundamentals include:

  * **`class` keyword:** Used to declare a class.
  * **`constructor` method:** A special method for creating and initializing an object created with a class. It's called automatically when a new instance of the class is created.
  * **Methods:** Functions defined within a class that operate on an instance of that class.

<!-- end list -->

```javascript
class Person {
  // The constructor initializes the object's properties
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }

  // A method for the class
  greet() {
    console.log(`Hello, my name is ${this.name} and I am ${this.age} years old.`);
  }
}

// Create a new instance of the Person class
const john = new Person('John Doe', 30);
john.greet(); // Outputs: Hello, my name is John Doe and I am 30 years old.
```

-----

### Explain ES6 class inheritance

Class inheritance is a mechanism where a new class (a **child** or **subclass**) can inherit properties and methods from an existing class (a **parent** or **superclass**). This promotes code reuse.

ES6 provides the `extends` and `super` keywords to handle inheritance.

  * **`extends`:** Used in the class declaration to specify the parent class.
  * **`super()`:** Used within the child's `constructor` to call the parent class's constructor. It must be called *before* using the `this` keyword in the child constructor.

<!-- end list -->

```javascript
// Parent class
class Animal {
  constructor(name) {
    this.name = name;
  }

  speak() {
    console.log(`${this.name} makes a noise.`);
  }
}

// Child class inheriting from Animal
class Dog extends Animal {
  constructor(name, breed) {
    super(name); // Call the parent constructor
    this.breed = breed;
  }

  speak() {
    console.log(`${this.name} barks.`);
  }
}

const myDog = new Dog('Rex', 'German Shepherd');
myDog.speak(); // Outputs: Rex barks.
```

-----

### Define ES6 arrow functions

Arrow functions (`=>`) provide a concise syntax for writing function expressions. They have two main benefits over traditional function expressions: a shorter syntax and a non-binding `this`.

1.  **Concise Syntax:** They are shorter and easier to write. If the function has only one expression, it can be written on one line with an implicit `return`.

    ```javascript
    // Traditional function
    const add = function(a, b) {
      return a + b;
    };

    // Arrow function
    const addArrow = (a, b) => a + b;
    ```

2.  **Lexical `this` Binding:** Arrow functions do not have their own `this` context. Instead, they inherit `this` from the surrounding code (the lexical scope). This is extremely useful for things like event handlers in React class components, as it avoids the need to `.bind(this)`.

-----

### Identify set(), map()

`Set` and `Map` are new data structures introduced in ES6 for storing collections of data.

  * **`Set`**
    A `Set` object lets you store a collection of **unique values** of any type. It automatically handles uniqueness, so you can't add the same value twice. A common use case is removing duplicates from an array.

    ```javascript
    const numbers = [1, 2, 2, 3, 4, 4, 5];
    const uniqueNumbers = new Set(numbers);
    console.log(uniqueNumbers); // Outputs: Set(5) { 1, 2, 3, 4, 5 }
    ```

  * **`Map`**
    A `Map` object holds **key-value pairs**, similar to a regular `Object`. However, a key in a `Map` can be of **any data type** (including objects and functions), whereas keys in a standard `Object` must be strings or symbols.

    ```javascript
    const userMap = new Map();
    const user1 = { id: 1 };

    // Set a key-value pair where the key is an object
    userMap.set(user1, { name: 'Alice', role: 'Admin' });

    console.log(userMap.get(user1)); // Outputs: { name: 'Alice', role: 'Admin' }
    ```

---

### **Define JSX**

JSX stands for **JavaScript XML**. It's a syntax extension for JavaScript that allows you to write HTML-like code directly within your JavaScript files. It's used with React to describe what the UI should look like in a declarative and familiar way.

While it looks like HTML, it is not. Browsers cannot read JSX directly. It must first be compiled by a tool like **Babel** into regular JavaScript function calls, specifically `React.createElement()`.

```jsx
// This is JSX
const element = <h1>Hello, world!</h1>;
```

-----

### **Explain about ECMA Script**

**ECMAScript (ES)** is a scripting language specification standardized by Ecma International. Think of it as the **blueprint or standard that JavaScript is based on**. Different versions of ECMAScript introduce new features and syntax to the language.

Modern React development relies heavily on features introduced in **ES6 (also known as ES2015)** and later versions. Some key ES6+ features you'll constantly use in React are:

  * **`let` and `const`:** For block-scoped variable declarations.
  * **Arrow Functions:** `() => {}` for a more concise function syntax.
  * **Classes:** Used for creating class components (though functional components with hooks are now more common).
  * **Destructuring:** Easily extracting values from objects and arrays.
  * **Modules:** `import` and `export` for organizing code into separate files.

-----

### **Explain React.createElement()**

`React.createElement()` is the core function that JSX gets compiled into. Under the hood, every JSX tag is just syntactic sugar for a call to this function. It creates a lightweight JavaScript object that describes what should be rendered on the screen. React then reads this object to construct the DOM.

The function has the following structure:
`React.createElement(type, [props], [...children])`

  * **`type`**: The element type. It can be an HTML tag name as a string (e.g., `'div'`, `'h1'`) or a React component (e.g., `Button`).
  * **`[props]`**: An object containing the properties (attributes) you want to pass to the element, like `{ className: 'greeting' }`.
  * **`[...children]`**: The content inside the element. This can be a string of text or more `React.createElement()` calls for nested elements.

For example, this JSX:

```jsx
const element = <h1 className="greeting">Hello, world!</h1>;
```

...is compiled into this JavaScript:

```javascript
const element = React.createElement(
  'h1',
  {className: 'greeting'},
  'Hello, world!'
);
```

-----

### **Explain how to create React nodes with JSX**

You create React nodes (or elements) simply by writing the HTML-like JSX syntax and assigning it to a variable or returning it from a component. These are not real DOM nodes; they are lightweight JavaScript objects that React uses as a blueprint to create the actual DOM nodes.

Here's how you can create a simple React node using JSX.

```jsx
// This creates a React node and stores it in the 'myElement' variable.
const myElement = (
  <div>
    <h1>Welcome to my App!</h1>
    <p>This is a paragraph inside a div.</p>
  </div>
);

// You can then use this 'myElement' variable within other components
// or render it directly to the DOM.
```

-----

### **Define how to render JSX to DOM**

To render a JSX element into the actual browser DOM, you use the `react-dom/client` library. The process involves two main steps:

1.  **Create a Root:** You first identify a "root" DOM element in your HTML file (usually a `<div>` with an id like `root`). Then, you use `ReactDOM.createRoot()` to tell React to manage the content inside that DOM element.
2.  **Render the Element:** You call the `render()` method on the created root and pass the JSX element you want to display.

Here is the complete process:

**1. Your HTML file (`public/index.html`)**

```html
<body>
  <div id="root"></div> </body>
```

**2. Your JavaScript file (`src/index.js`)**

```jsx
import React from 'react';
import ReactDOM from 'react-dom/client';

// The JSX element you want to render
const elementToRender = <h1>Hello, React! 👋</h1>;

// 1. Get the root DOM node
const rootNode = document.getElementById('root');

// 2. Create a React root
const root = ReactDOM.createRoot(rootNode);

// 3. Render your element into the root
root.render(elementToRender);
```

-----

### **Explain how to use JavaScript expressions in JSX**

You can embed any valid JavaScript expression inside JSX by wrapping it in **curly braces `{}`**. This allows you to dynamically insert data, run calculations, or call functions directly within your UI markup.

You can place expressions in the content of a tag or even in its attributes.

```jsx
function UserProfile() {
  const user = {
    name: 'Alex',
    age: 28,
    avatarUrl: 'https://i.imgur.com/some-image.jpeg'
  };

  function formatName(user) {
    return user.name.toUpperCase();
  }

  return (
    <div>
      {/* Rendering a variable */}
      <h1>Name: {user.name}</h1>

      {/* Doing a calculation */}
      <p>Age next year: {user.age + 1}</p>

      {/* Calling a function */}
      <p>Formatted Name: {formatName(user)}</p>

      {/* Using an expression in an attribute */}
      <img src={user.avatarUrl} alt={user.name} />
    </div>
  );
}
```

-----

### **Explain how to use inline CSS in JSX**

To apply inline styles in JSX, you use the `style` attribute. Unlike in HTML where you pass a string, in JSX you must pass a **JavaScript object**.

Key differences from standard CSS:

  * The properties are written in **camelCase** (e.g., `backgroundColor` instead of `background-color`).
  * The values are typically strings.

<!-- end list -->

```jsx
// 1. Define your styles as a JavaScript object
const headingStyle = {
  color: 'white',
  backgroundColor: 'dodgerblue',
  padding: '10px',
  fontFamily: 'Arial',
  borderRadius: '5px'
};

function StyledHeader() {
  return (
    // 2. Pass the style object to the style attribute
    <h1 style={headingStyle}>
      This is a styled heading.
    </h1>
  );
}

// You can also define the object directly inline (using double curlies)
function AnotherStyledHeader() {
  return (
    <h1 style={{ color: 'red', textAlign: 'center' }}>
      This is another styled heading.
    </h1>
  );
}
```
---

### Explain React events

React events are actions that your application can respond to, such as a user clicking a button, hovering over an element, or typing in an input field. Handling events in React elements is very similar to handling events on DOM elements. However, there are two key differences:

1.  React events are named using **camelCase** rather than lowercase.
2.  With JSX, you pass a **function** as the event handler, rather than a string.

These events are not the browser's native events but are special objects called **Synthetic Events**.

-----

### Explain about event handlers

An **event handler** is a function that gets executed in response to a specific event. In React, you define this function within your component and then pass it as a prop to the JSX element you want to monitor.

For example, to handle a button click, you would pass a function to the button's `onClick` prop.

```jsx
function ActionButton() {
  // This is the event handler function
  const handleClick = () => {
    alert('Button was clicked! 🎉');
  };

  return (
    // The handleClick function is passed to the onClick prop
    <button onClick={handleClick}>
      Click Me
    </button>
  );
}
```

-----

### Define Synthetic event

A **`SyntheticEvent`** is a cross-browser wrapper that React uses for its event system. It's an object that normalizes the browser's native event, ensuring that events behave consistently across different browsers (like Chrome, Firefox, and Safari).

When you use an event handler like `onClick`, the event object passed to your handler function (e.g., `handleClick(event)`) is a `SyntheticEvent`. It has the same interface as the standard browser event, including methods like `event.preventDefault()` and `event.stopPropagation()`, but it guarantees they work the same everywhere.

-----

### Identify React event naming convention

React events follow the **camelCase** naming convention. This means the event name starts with "on" followed by the event type, with the first letter of the event type capitalized.

This is different from standard HTML, which uses all lowercase.

Here are a few common examples:

  * **React:** `onClick` | **HTML:** `onclick`
  * **React:** `onChange` | **HTML:** `onchange`
  * **React:** `onMouseEnter` | **HTML:** `onmouseenter`
  * **React:** `onSubmit` | **HTML:** `onsubmit`

---

### Explain about conditional rendering in React

Conditional rendering is the process of displaying different UI elements or components based on the application's current **state** or **props**. It allows you to create dynamic user interfaces that change in response to user actions or data changes.

The most common ways to implement conditional rendering are:

  * **Ternary Operator (`? :`):** A concise way to handle simple `if-else` logic directly within your JSX.
    ```jsx
    function LoginStatus({ isLoggedIn }) {
      return (
        <div>
          {isLoggedIn ? <p>Welcome back!</p> : <p>Please log in.</p>}
        </div>
      );
    }
    ```
  * **Logical AND Operator (`&&`):** Perfect for rendering an element *only if* a condition is true. If the condition is false, nothing is rendered.
    ```jsx
    function NotificationBadge({ count }) {
      return (
        <div>
          {count > 0 && <span>You have {count} new notifications.</span>}
        </div>
      );
    }
    ```

-----

### Define element variables

An **element variable** is a standard JavaScript variable used to hold a JSX element. This approach is helpful when you have more complex conditional logic that isn't suitable for an inline ternary operator.

You can declare a variable (e.g., with `let`) and then use `if-else` statements to assign different components or JSX to it based on your conditions. Finally, you render that variable within your component's return statement.

```jsx
function Greeting({ isLoggedIn }) {
  let content; // This is the element variable

  if (isLoggedIn) {
    content = <h1>Welcome back! 👋</h1>;
  } else {
    content = <h1>Please sign up.</h1>;
  }

  return (
    <div>
      {content} {/* Render the variable here */}
    </div>
  );
}
```

-----

### Explain how to prevent components from rendering

To prevent a component from rendering anything, you can have it **return `null`**. When React sees that a component returns `null`, it understands that it should not render anything to the DOM for that component.

This is a clean and common pattern for conditionally hiding a component entirely.

```jsx
function WarningBanner({ showWarning }) {
  // If showWarning is false, the component renders nothing.
  if (!showWarning) {
    return null;
  }

  // Otherwise, it renders the warning div.
  return (
    <div className="warning">
      Warning! 🚨
    </div>
  );
}

// How to use it:
// <WarningBanner showWarning={true} />  -> Renders the div
// <WarningBanner showWarning={false} /> -> Renders nothing
```

### **Explain various ways of conditional rendering**

Conditional rendering in React allows you to render different UI elements or components based on certain conditions or states. It works the same way conditions work in JavaScript. Here are the most common ways to do it.

  * **`if`/`else` Statement**
    This is the most basic way. You can use a standard JavaScript `if` statement to return different JSX. This is useful when the logic is complex or you need to return entirely different component structures.

    ```jsx
    function Greeting({ isLoggedIn }) {
      if (isLoggedIn) {
        return <h1>Welcome back!</h1>;
      }
      return <h1>Please sign up.</h1>;
    }
    ```

  * **Ternary Operator (`? :`)**
    For simpler, inline conditions, the ternary operator is a clean and concise choice. It's great for switching between two options. The syntax is `condition ? expressionIfTrue : expressionIfFalse`.

    ```jsx
    function UserStatus({ isLoggedIn }) {
      return (
        <div>
          The user is <b>{isLoggedIn ? 'currently' : 'not'}</b> logged in.
        </div>
      );
    }
    ```

  * **Logical `&&` Operator (Short-circuiting)**
    This is perfect when you want to render something **only if** a condition is true, and render nothing otherwise. If the condition is true, the expression after `&&` will be the output. If it's false, React ignores it.

    ```jsx
    function Mailbox({ unreadMessages }) {
      return (
        <div>
          <h1>Hello!</h1>
          {unreadMessages.length > 0 &&
            <h2>
              You have {unreadMessages.length} unread messages.
            </h2>
          }
        </div>
      );
    }
    ```

-----

### **Explain how to render multiple components**

To render multiple components, you simply place them next to each other in your JSX, just like you would with HTML tags. All sibling components must be wrapped in a single parent element, like a `<div>`, or by using a **React Fragment** (`<>...</>`) if you don't want to add an extra node to the DOM.

Here's an example where a parent `App` component renders multiple `Welcome` components.

```jsx
// The component to be rendered multiple times
function Welcome(props) {
  return <h1>Hello, {props.name}</h1>;
}

// The parent component rendering multiple Welcome components
function App() {
  return (
    <>
      <Welcome name="Sara" />
      <Welcome name="Cahal" />
      <Welcome name="Edite" />
    </>
  );
}
```

-----

### **Define list component**

A **list component** is a component that is specifically designed to render a list of items. It takes an array of data (like numbers, strings, or objects) and uses a loop, typically the JavaScript `map()` function, to transform that data into a list of JSX elements that can be displayed on the screen.

For example, a `TodoList` component would take an array of `todos` and render an `<li>` for each one.

-----

### **Explain about keys in React applications**

**Keys** are a special string attribute you need to include when creating lists of elements from an array.

The main purpose of keys is to help React **identify** which items in a list have **changed, been added, or been removed**. When a list is re-rendered, React uses the `key` to match the items from the previous render with the items from the new render.

Why are they important?

  * **Performance:** By matching keys, React can be much more efficient. Instead of re-creating the entire list, it can just update, move, or remove the specific elements that have changed.
  * **State Preservation:** Keys ensure that the internal state of a component (like input text in a form) is preserved correctly when the list is re-ordered or filtered.

Keys must be:

  * **Unique** among their siblings in the list.
  * **Stable** and **predictable**. They shouldn't change between renders. Using an item's unique `id` from your data is the best practice.

⚠️ **Avoid using the array index as a key** if the order of items may change. This can lead to bugs with component state and performance issues because changing the order will change the index, confusing React.

```jsx
// Good practice: using a stable ID as the key
const todoItems = todos.map((todo) =>
  <li key={todo.id}>
    {todo.text}
  </li>
);
```

-----

### **Explain how to extract components with keys**

When your list items become complex, it's good practice to extract them into their own components to keep your code clean and reusable.

When you do this, the **`key` should always be applied to the component in the `map()` loop**, not inside the component you've extracted. The `key` is a hint for React's rendering algorithm and needs to be on the elements in the array itself.

Let's see an example.

**Before (inline list item):**

```jsx
function TodoList({ todos }) {
  const listItems = todos.map((todo) =>
    <li key={todo.id}>
      <h2>{todo.title}</h2>
      <p>{todo.description}</p>
    </li>
  );
  return <ul>{listItems}</ul>;
}
```

**After (extracted component):**
Here, we extract the list item into a `TodoItem` component. Notice where the `key` is placed.

```jsx
// 1. The extracted component. It receives data via props. No key here!
function TodoItem(props) {
  return (
    <li>
      <h2>{props.title}</h2>
      <p>{props.description}</p>
    </li>
  );
}

// 2. The list component. The key is applied here!
function TodoList({ todos }) {
  const listItems = todos.map((todo) =>
    <TodoItem
      key={todo.id} // The key goes on the component in the array
      title={todo.title}
      description={todo.description}
    />
  );
  return <ul>{listItems}</ul>;
}
```

-----

### **Explain React Map, map() function**

First, it's important to clarify that `map()` is **not a React-specific function**. It's a standard method on JavaScript arrays. However, it's fundamental to how we render lists in React.

The `Array.prototype.map()` function works by iterating over every element in an array and running a callback function on it. It then collects the results from each function call into a **new array**.

In React, we use `map()` to transform an array of data into an array of JSX elements. React can then take this array of elements and render it to the DOM.

Here’s a breakdown of how it's used:

1.  You start with an array of data (e.g., `const numbers = [1, 2, 3, 4, 5];`).
2.  You call `.map()` on this array.
3.  Inside the `map` callback, you return a JSX element for each item.
4.  The `map()` function returns a new array, now filled with your JSX elements.

<!-- end list -->

```jsx
function NumberList({ numbers }) {
  // `numbers` is an array, e.g., [1, 2, 3]

  // Use map() to transform the array of numbers into an array of <li> elements
  const listItems = numbers.map((number) =>
    // The key is essential for lists
    <li key={number.toString()}>
      {number}
    </li>
  );

  // The `listItems` variable now holds:
  // [
  //   <li key="1">1</li>,
  //   <li key="2">2</li>,
  //   <li key="3">3</li>
  // ]

  return (
    <ul>
      {listItems}
    </ul>
  );
}
```