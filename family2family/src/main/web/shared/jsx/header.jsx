import React from 'react';
import F2FLogoImg from '../image/f2f-logo.png'
import styles from '../css/header.css'

class Header extends React.Component {
    render () {
        return (
            <div className="page-header navbar row">
                <div className="container col-lg-12">
                    <div className="navbar-header row col-sm-10 col-lg-8 col-md-8">
                        <div id="logo-pic" className="col-sm-12 col-md-2 col-lg-2">
                        <img src={F2FLogoImg} />
                        </div>
                        <div id="site-title" className="col-sm-12 col-md-8 col-lg-8">
                            <div id="sitewise-title"> <a className="navbar-brand" href="/">Childrens Brain Tumor Foundation</a></div>
                            <div id="page-title"><a className="navbar-brand" href="#">{this.props.pageTitle}</a></div>
                        </div>
                    </div>
                    <div id="navbar" className="navbar-collapse">
                        <form className="navbar-form navbar-right logout-button-section" action="/logout" method="post">
                            <input className="btn btn-danger center-block" id="logout-button" type="submit" value="Logout" />
                        </form>
                    </div>
                </div>
            </div>
        )
    }
}
export default Header;