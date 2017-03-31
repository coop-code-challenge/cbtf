class User extends React.Component {
    displayEdit(e) {
        e.preventDefault();
        if (document.getElementsByClassName("edit-collapse")[0].style.display == 'inline-block') {
            document.getElementsByClassName("edit-collapse")[0].style.display = 'none';
        } else {
            document.getElementsByClassName("edit-collapse")[0].style.display = 'inline-block';
        }
    }

    render() {
        return (
            <div>
                <a className="row" onClick={this.displayEdit.bind(this)}>
                    <div className="col-sm-3">{this.props.user.userId}</div>
                    <div
                        className="col-sm-3">{this.props.user.firstName + " " + this.props.user.lastName}</div>
                    <div className="col-sm-3">
                        <input type="checkbox" name="admin"
                               checked={this.props.user.admin} disabled={true}/>
                    </div>
                    <div className="col-sm-3">
                        <input type="checkbox" name="active"
                               checked={this.props.user.active} disabled={true}/>
                    </div>
                </a>
                <div className="edit-collapse">
                    <EditUserRow id={this.props.user.userId}
                                 firstName={this.props.user.firstName}
                                 lastName={this.props.user.lastName}
                                 admin={this.props.user.admin}
                                 active={this.props.user.active}/>
                </div>
            </div>
        )
    }
}

class EditUserRow extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            id: props.id,
            firstName: props.firstName,
            lastName: props.lastName,
            admin: props.admin,
            active: props.active
        };
    }

    handleChange(event) {
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value;
        const name = target.name;

        this.setState({
          [name]: value
        });
    }

    render() {
        return (
            <div className="edit-user-row">
                <form className="form-horizontal">
                    <div className="form-group">
                        <label className="control-label col-sm-2" htmlFor="id">User
                            ID: </label>
                        <div className="col-sm-3">
                            <input type="text" className="form-control" name="id"
                                   value={this.state.id} onChange={this.handleChange}/>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-sm-2" htmlFor="fname">First
                            Name:</label>
                        <div className="col-sm-3">
                            <input type="text" className="form-control" name="fname"
                                   value={this.state.firstName}
                                   onChange={this.handleChange}/>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-sm-2" htmlFor="lname">Last
                            Name: </label>
                        <div className="col-sm-3">
                            <input type="text" className="form-control" name="lname"
                                   value={this.state.lastName}
                                   onChange={this.handleChange}/>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-md-2" htmlFor="admin">Administrator: </label>
                        <div className="col-sm-3">
                            <div className="checkbox">
                                <input type="checkbox" name="admin"
                                       checked={this.state.admin}
                                       onChange={this.handleChange}/>
                            </div>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-md-2"
                               htmlFor="active">Active: </label>
                        <div className="col-sm-3">
                            <div className="checkbox">
                                <input type="checkbox" name="active"
                                       checked={this.state.active}
                                       onChange={this.handleChange}/>
                            </div>
                        </div>
                    </div>
                    <div className="button-group">
                        <button type="submit" className="btn btn-danger delete col-sm-1">Delete</button>
                        <button type="submit" className="btn col-sm-1">Reset</button>
                        <button type="submit" className="btn btn-primary col-sm-1">Save</button>
                    </div>
                </form>
            </div>
        )
    }
}

class UserTable extends React.Component {
    constructor(props) {
        super(props);
        this.state = {users: []};
    }

    componentDidMount() {
        $.getJSON('/internal-api/Users').then((data) => {
            this.setState({users: data._embedded.Users});
        })
    }

    render() {
        let users = this.state.users.map(user =>
            <User key={user.userId} user={user}/>
        );
        return (
            <div>
                <div className="row">
                    <div className="col-xs-3">
                        User Id
                    </div>
                    <div className="col-xs-3">
                        User Name
                    </div>
                    <div className="col-xs-3">
                        Administrator
                    </div>
                    <div className="col-xs-3">
                        Active
                    </div>
                </div>
                {users}
            </div>
        )
    }
}

class TabContentFrames extends React.Component {
    render() {
        return (
            <div className="container">
                <div className="users-frame">
                    <UserTable />
                </div>
                <div className="ref-tables-frame">
                    <h1>This is the ref table tab</h1>
                </div>
            </div>
        )
    }
}

class TabBarComponent extends React.Component {

    displayUsers(e) {
        e.preventDefault();
        document.getElementsByClassName("ref-tables-frame")[0].style.display = 'none';
        document.getElementsByClassName("users-frame")[0].style.display = 'block';
    }

    displayRefTable(e) {
        e.preventDefault();
        document.getElementsByClassName("users-frame")[0].style.display = 'none';
        document.getElementsByClassName("ref-tables-frame")[0].style.display = 'block';
    }

    render() {
        return (
            <div className="container">
                <ul className="nav nav-tabs">
                    <li><a onClick={this.displayUsers.bind(this)}>Users</a></li>
                    <li><a onClick={this.displayRefTable.bind(this)}>Reference Tables</a>
                    </li>
                </ul>
                <TabContentFrames />
            </div>
        )
    }
}

class AppContent extends React.Component {
    //TODO add routing or page state handling
    render() {
        return (
            <div>
                <TabBarComponent/>
            </div>
        );
    }
}

ReactDOM.render(<AppContent />, document.getElementById('appContent'));