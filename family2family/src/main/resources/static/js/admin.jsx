class User extends React.Component {
    constructor(props) {
        super(props);

        this.state = {userid: "", username: "", adminchecked: {false}, activechecked: {false}, showReply: {false}};
    }

    onClick(e){
        e.preventDefault();
        this.setState({showReply: !this.state.showReply})
    }

    render() {
        return(
            <div>
                <a className="row" data-toggle="collapse" onClick={this.onClick.bind(this)}>
                    <div className="col-sm-3">{this.props.userid}</div>
                    <div className="col-sm-3">{this.props.username}</div>
                    <div className="col-sm-3">
                        <input type="checkbox" name="admin" checked={this.props.adminchecked} disabled={true}/>
                    </div>
                    <div className="col-sm-3">
                        <input type="checkbox" name="active" checked={this.props.activechecked} disabled={true}/>
                    </div>
                </a>
                {this.state.showReply && <EditUserRow />}
            </div>
        )
    }
}

class UserTable extends React.Component {
    render() {
        return(
            <div class="container">
                <div className="tableheader">Users</div>
                <div className="row">
                    <div className="col-sm-3 bold">User ID</div>
                    <div className="col-sm-3 bold">Name</div>
                    <div className="col-sm-3 bold">Administrator</div>
                    <div className="col-sm-3 bold">Active?</div>
                </div>
                <User userid="WADE123" username="Wade Iwata" adminchecked={false} activechecked={true} />
                <User userid="WADE123" username="Wade Iwata" adminchecked={false} activechecked={true} />
                <User userid="WADE123" username="Wade Iwata" adminchecked={false} activechecked={true} />
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
                        <li className="active"><a href="#">Home</a></li>
                        <li><a href="#Page1">Page 1</a></li>
                        <li><a href="#Page2">Page 2</a></li>
                        <li><a href="#Page3">Page 3</a></li>
                    </ul>
                </div>
            </nav>
        )
    }
}

class TabContentFrames extends React.Component {
    render() {
        return (
            <div className="container">
                <div className="usersFrame">
                    <h1>This is the users tab</h1>
                    <UserTable />
                </div>
                <div className="">
                    <h1>This is the ref table tab</h1>
                </div>
            </div>
        )
    }
}

class TabBarComponent extends React.Component {

    displayUsers(e){
        e.preventDefault();
        console.log("Users Frame");
        document.getElementsByClassName("")[0].style.display = 'none';
        document.getElementsByClassName("usersFrame")[0].style.display = 'block';
    }

    displayRefTable(e) {
        e.preventDefault();
        console.log("RefTable");
        document.getElementsByClassName("usersFrame")[0].style.display = 'none';
        document.getElementsByClassName("")[0].style.display = 'block';
    }

    render() {
        return(
            <div className="container">
                <ul className="nav nav-tabs">
                    <li><a onClick={this.displayUsers.bind(this)}>Users</a></li>
                    <li><a onClick={this.displayRefTable.bind(this)}>Reference Tables</a></li>
                </ul>
                <TabContentFrames />
            </div>
        )
    }
}
//
// function displayUsers() {
//     console.log("?Herrrro~");
//     ReactDOM.getElementsByClassName("").style.display = 'none';
//     ReactDOM.getElementsByClassName("usersFrame").style.display = 'block';
// }
//
// function displayRefTable() {
//     console.log("?Herrrwerwerwerwerro~");
//
//
//     ReactDOM.getElementsByClassName("usersFrame").style.display = 'none';
//     ReactDOM.getElementsByClassName("").style.display = 'block';
// }

class EditUserRow extends React.Component {
    constructor(props) {
        super(props);
        this.state = {userid:"", fname:"", lname:"", admin:{true}, activeUser:{false}};
    }

    handleChange(event) {
        this.setState({value: event.target.value});
    }


    render() {
        return(
            <div class="editUserRow" className="editUserRow">
                <form className="form-horizontal" >
                    <div className="form-group">
                        <label className="control-label col-sm-2" for="userid">User ID: </label>
                        <div className="col-sm-3">
                            <input type="text" className="form-control" name="userid" value={this.props.userid} onChange={this.handleChange}/>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-sm-2" for="fname">First Name:</label>
                        <div className="col-sm-3">
                            <input type="text" className="form-control" name="fname" value={this.state.fname} onChange={this.handleChange}/>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-sm-2" for="lname">Last Name: </label>
                        <div className="col-sm-3">
                            <input type="text" className="form-control" name="lname" value={this.state.lname} onChange={this.handleChange}/>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-md-2" for="admin">Administrator: </label>
                        <div className="col-sm-3">
                            <div className="checkbox">
                                <input type="checkbox" name="admin" value={this.state.admin} onChange={this.handleChange}/>
                            </div>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="control-label col-md-2" for="active">Active: </label>
                        <div className="col-sm-3">
                            <div className="checkbox">
                                <input type="checkbox" name="active" value={this.state.active} onChange={this.handleChange}/>
                            </div>
                        </div>
                    </div>
                    <div className="button-group">
                        <button type="submit" className="btn delete col-sm-1">Delete</button>
                        <button type="submit" className="btn col-sm-1">Reset</button>
                        <button type="submit" className="btn btn-primary col-sm-1">Save</button>
                    </div>
                </form>
            </div>
        )
    }
}

class AppContent extends React.Component {
    //TODO add routing or page state handling
    render() {
        return (
            <div>
                <NavBarComponent />
                <TabBarComponent/>
            </div>
        );
    }
}

ReactDOM.render(<AppContent />, document.getElementById('appContent'));