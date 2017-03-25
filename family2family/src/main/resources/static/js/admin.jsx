class User extends React.Component {
    constructor(props) {
        super(props);

        this.state = {userID: "+ Add User", username: "", adminchecked: {false}, activechecked: {false}};
    }

    render() {
        return(
            <tr>
                <td>{this.props.userID}</td>
                <td>{this.props.username}</td>
                <td>{this.props.adminchecked}</td>
                <td>{this.props.activechecked}</td>
            </tr>
        )
    }
}

class UserTable extends React.Component {
    render() {
        return(
            <div class="container">
                <table class="table">
                    <thead>
                    <tr>
                        <th>User ID</th>
                        <th>Name</th>
                        <th>Administrator</th>
                        <th>Active</th>
                    </tr>
                    </thead>
                    <tbody>
                        <User userID="+ Add User" username="Kory" adminchecked="false" activechecked="true" />
                    </tbody>
                </table>
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
                <UserTable />
            </div>
        );
    }
}

ReactDOM.render(<AppContent />, document.getElementById('appContent'));