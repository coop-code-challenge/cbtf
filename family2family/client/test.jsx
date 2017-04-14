import React, { Component } from 'react'
import { BrowserRouter, HashRouter, Route } from 'react-router-dom'

class App extends Component {
    render() {
        return (
            <HashRouter>
                <div>
                    <Route exact path='/' component={Home} />
                    <Route path='/address' component={Address} />
                </div>
            </HashRouter>
        )
    }
}

const Home = () => <h1>Hello from Home!</h1>
const Address = () => <h1>We are located at 555 Jackson St.</h1>

export default App