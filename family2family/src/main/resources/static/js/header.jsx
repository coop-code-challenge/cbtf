class HeaderComponent extends React.Component {
    render() {
        return(
            <nav className="navbar">
                <div className="container">
                    <div className="navbar-header">
                        <div id="logo-pic">
                            <img src="/image/f2f-logo.png" />
                        </div>

                        <div id="site-title">
                            <div id="sitewise-title"> <a className="navbar-brand" href="/">Childrens Brain Tumor Foundation</a></div>
                            <div id="page-title"><a className="navbar-brand" href="#"></a></div>
                        </div>
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