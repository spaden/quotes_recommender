
import './button.scss'

function Button(props) {
    
    return (
      <button className="btn buttoncomponent"
              onClick={props.onClick}>
        {props.name}
      </button>
    );
  }

  export default Button