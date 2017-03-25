
class NavBarComponent extends React.Component {
    render() {
        return(
            <nav className="navbar navbar-default">
                <div className="container-fluid">
                    <ul className="nav navbar-nav">
                        <li className="active"><a href="#">Home</a></li>
                        <li><a href="#Contact Entry">Contact Entry</a></li>
                        <li><a href="#Find a Mentor">Find a Mentor</a></li>
                        <li><a href="#Admin Settings">Admin Settings</a></li>
                    </ul>
                </div>
            </nav>
        )
    }
}

class AlreadySignedIn extends React.Component {
    constructor(props) {
        super(props);

        this.state = {person: []};
    }

    componentWillMount() {
        $.getJSON('/api/user').then((data) => {
            this.setState({person: data});
        });
    }

    render() {
        return(
            <div>
                <span>{this.state.person.givenName}, contact an admin to set up your account.</span>
            </div>
        );
    }
}

class AppContent extends React.Component {
    //TODO add routing or page state handling
    render() {
        return (
            <div>
                <NavBarComponent />
                <AlreadySignedIn />
            </div>
        );
    }
}

ReactDOM.render(<AppContent />, document.getElementById('appContent'));