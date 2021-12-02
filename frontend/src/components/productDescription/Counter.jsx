// Code goes here

(function() {
  
    /*
    ReactDOM.render(
      <h2>Hello, Suneel</h2>,
      document.getElementById('mount-point')
      );
    */
    // Sample Component
    // ReactDOM.render(
    //     React.createElement('h2', null, 'Hello Suneel Korada'),
    //     document.getElementById('mount-point')
    //   );
  
    // First Component
    var FirstComponent = React.createClass({
      render: function() {
        return (<div className="first-comp">This is My First Component</div>);
      }
    });
    
    ReactDOM.render(
        <FirstComponent/>,
        document.getElementById('first-component')
      );
  
    // Second Component
    var SecondComponent = React.createClass({
      render: function(){
        return (
            <div className="second-comp">{this.props.compName} created by - {this.props.name} </div>
          );
      }
    });
    
    ReactDOM.render(
        <SecondComponent compName="Second Component" name="Suneel Korada"/>,
        document.getElementById('second-component')
      );
      
    // Third Component (used initial state)
    var ThirdComponent = React.createClass({
      getInitialState: function(){
        return {
          compName: 'Third Component'
        };
      },
      render: function(){
        return (
            <div className="third-comp">{this.state.compName} created using {this.props.type}</div>
          );
      }
    });
    
    ReactDOM.render(
      <ThirdComponent type="State"/>,
      document.getElementById('third-component')
    );
    
    var IncrementComponent = React.createClass({
      render: function() {
        return (
            <div>
            <button onClick={this.doDecrement} className="fa fa-minus fa-inverse fa-2x"></button>
            <input type="text" className="number" value={this.state.value }></input>
            <button onClick={this.doIncrement} className="fa fa-plus fa-inverse fa-2x"></button>
            <sub>{this.state.message}</sub>
            </div>
          );
      },
      getInitialState: function(){
        return {
          value: 0,
          message: null
        }
      },
      doDecrement: function() {
        if(this.state.value) {
          this.setState({
            value: this.state.value - 1,
            message: null
          });
        } else {
          this.setState({
            message: "Can't decrement. Since 0 is the min value"
          });
        }
      },
      doIncrement: function() {
        if(this.state.value < 10) {
          this.setState({
            value: this.state.value + 1,
            message: null
          });
        } else {
          this.setState({
            message: "Can't increment. Since 10 is the max value"
          });
        }
      }
    });
    
    // Increment Component
    ReactDOM.render(
      <IncrementComponent/>,
      document.getElementById('increment-component')
      );
  })();
  
  //https://scotch.io/tutorials/learning-react-getting-started-and-concepts