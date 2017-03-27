class NavBarComponent extends React.Component {
    render() {
        return(
            <nav className="navbar">
                <div className="container-fluid">
                    <ul className="nav navbar-nav">
                        <li className="active"><a href="/">Home</a></li>
                        <li><a href="contact-entry" id="contact-entry">Contact Entry</a></li>
                        <li><a href="find-a-mentor" id="find-a-mentor">Find a Mentor</a></li>
                        <li><a href="admin" id="admin-settings">Admin Settings</a></li>
                    </ul>
                </div>
            </nav>
        )
    }
}

ReactDOM.render(<NavBarComponent />, document.getElementById('navBar'));