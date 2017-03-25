class User extends React.Component {
    constructor(props) {
        super(props);

        this.state = {username: "", name: "", adminchecked: {false}, activechecked: {false}};
    }
    render() {
        return(
            <div className="container-fluid">
                <div className="container-fluid">{this.props.username}</div>
                <div className="container-fluid">{this.props.name}</div>
                <input name="admin" type="checkbox" checked={this.props.adminchecked} onClick={this.props.adminchecked}/>
                <input name="active" type="checkbox" checked={this.props.activechecked} />
            </div>
        )
    }
}

class NavBarComponent extends React.Component {
    render() {
        return(
            <nav className="navbar navbar-default">
                <div className="container-fluid">
                    <ul className="nav navbar-nav">
                       <li><a href="">Users</a></li>
                       <li><a href="">Reference Tables</a></li>
                   </ul>
                </div>
            </nav>
        )
    }
}

class AppContent extends React.Component {
    //TODO add routing or page state handling
    render() {
        return (
            <div>
                <NavBarComponent />
                <User className="container-fluid" username="koryten" name="Kory" adminchecked="true" activechecked="true" />
            </div>
        );
    }
}

ReactDOM.render(<AppContent />, document.getElementById('appContent'));