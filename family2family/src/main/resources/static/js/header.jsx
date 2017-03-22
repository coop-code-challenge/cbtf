class HeaderComponent extends React.Component {
    render() {
        return(
            <nav className="navbar navbar-inverse navbar-fixed-top">
                <div className="container">
                    <div className="navbar-header">
                        <a className="navbar-brand" href="#">Family 2 Family</a>
                    </div>
                    <div id="navbar" className="navbar-collapse collapse">
                        <form className="navbar-form navbar-right logout-button-section" action="/logout" method="post">
                            <input className="btn btn-danger center-block" type="submit" value="Logout" />
                        </form>
                    </div>
                </div>
            </nav>
        )
    }
}

ReactDOM.render(<HeaderComponent />, document.getElementById('mainHeader'));