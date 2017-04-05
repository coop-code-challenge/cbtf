import React from 'react';
import ReactDom from 'react-dom';
import MyComponent from './mycomponent.jsx';

class App extends React.Component {
    render () {
        return <div>
            <p> Hello React!</p>
            <MyComponent/>
        </div>;
    }
}

ReactDom.render(<App/>, document.getElementById('app'));
