// Use JSX files (JavaScript & XML)

class classA extends React.Component{
	render(){
		return <div> Name : {this.props.MyName} </div>;
	}			// all must be inside ONE div
}

ReactDOM.render(<classA MyName="bob" />,parentHTMLbyID);
// creates an HTML obj
	// recieve arguments with costume keys, exp: MyName
		// appeand to parentHTMLbyID (usually a div)
		
// Install
	// Method 1 : CDN (content delivery network)
	<script src="https://unpkg.com/react@15/dist/react.js"></script>
	<script src="https://unpkg.com/react-dom@15/dist/react-dom.js"></script>
	
	// Method 2 : CDN min
	<script src="https://unpkg.com/react@15/dist/react.min.js"></script>
	<script src="https://unpkg.com/react-dom@15/dist/react-dom.min.js"></script>
	
	// Method 3 : npm
	npm install -g create-react-app // only once
	create-react-app projectNAME
	cd projectNAME
	npm start {run the project}
		// steps
		// public/index.html has div id="root"
		// index.js takes from App.js and index.css(optional)
			// puts App.js into div is="root"
		// App.js has logo & App.css all optional
			// App.css only need to be included in the main App component
	* for getting unique IDs
		npm install --save uuid
	* for getting jQuery into the project
		npm install --save jquery
	
	// method 4 : npm add to existing project
	npm init
	npm install --save react react-dom
	
// READ ORDER EXAMPLE :
	in 02_project/src
	App.js
	MyComponents/01project.js
	MyComponents/02addState.js
	MyComponents/03projectStates.js