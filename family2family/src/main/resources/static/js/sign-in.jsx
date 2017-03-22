class SignInComponent extends React.Component{
    render() {
        return(
            <form className="navbar-form" action="/login" method="get">
                <button className="center-block sign-in-button" type="submit">
                    <img src="/image/btn_google_signin_light_normal_web.png" alt="Login With Google"/>
                </button>
            </form>
        )
    }
}

class AppContent extends React.Component {
    //TODO add routing or page state handling
    render() {
        return (
            <SignInComponent />
        );
    }
}

ReactDOM.render(<AppContent />, document.getElementById('appContent'));
