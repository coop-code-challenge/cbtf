class AdditionalInfoCard extends React.Component {
    render() {
        return (
            <div className="panel panel-primary">
                <div className="panel-heading">
                    <h3 className="panel-title">{this.props.title}</h3>
                </div>
                <div className="panel-body">
                    {this.props.items.map((item, index) => <p key={index}>{item}</p>)}
                </div>
            </div>
        );
    }
}