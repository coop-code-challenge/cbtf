class NavBarComponent extends React.Component {
    render() {
        return(
            <nav className="navbar">
                <div className="container-fluid">
                    <ul className="nav navbar-nav">
                        <li className="active"><a href="#">Home</a></li>
                        <li><a href="#Page1" id="contact-entry">Contact Entry</a></li>
                        <li><a href="#Page2" id="find-a-mentor">Find a Mentor</a></li>
                        <li><a href="#Page3" id="admin-settings">Admin Settings</a></li>
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




}

class AlertComponent extends React.Component{
    constructor(props) {
        super(props);

        this.state = {alerts: []};
    }

    componentWillMount() {
        $.getJSON('internal-api/AlertsUpdate').then((data) => {
            this.setState({alerts: data._embedded.AlertsUpdate});
            console.log(this.state.alerts);
        });
    }

    render(){
        let alertItems;
        if(this.state.alerts){
            alertItems = this.state.alerts.map(alert => {
                return (
                    <AlertItem key={alert.dateTime} alert={alert}/>
                )
            })
        }
        return (
            <div>
                {alertItems}
            </div>
        );
    }
}

class AlertItem extends React.Component {
    render(){
        var time = this.props.alert.dateTime;
        var date = (new Date (time).toDateString());
        return (
            <div>
                <h3>
                    {date}
                </h3>
                <p>{this.props.alert.message}</p>
            </div>
        );
    }
}

class AppContent extends React.Component {
    //TODO add routing or page state handling
    render() {
        return (
            <div>
                <h2>Updates and Alerts</h2>
                <AlertComponent />
            </div>
        );
    }
}
ReactDOM.render(<NavBarComponent />, document.getElementById('navBar'));
ReactDOM.render(<AppContent />, document.getElementById('appContent'));
