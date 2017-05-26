
import React from 'react';
import ReactDOM from 'react-dom'
import Header from '../../shared/jsx/header.jsx'
import SignInImage from '../image/sign-in-button.png'
import styles from '../css/f2f-sign-in.css'

class SignInComponent extends React.Component {
    render() {
        return(
            <form  action="/login" method="get">
                <button className="center-block sign-in-button" type="submit">
                    <img src={SignInImage} alt="Login With Google"/>
                </button>
            </form>
        )
    }
}

class AppContent extends React.Component {
    //TODO add routing or page state handling
    render() {
        return (
            <div>
                <Header />
                <SignInComponent />
            </div>
        );
    }
}

ReactDOM.render(<AppContent />, document.getElementById('app'));