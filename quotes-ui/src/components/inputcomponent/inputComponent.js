import './inputComponentStyle.scss'

function InputComponent(props) {
    const onInputChange = (e) => {
      props.onChange(e.currentTarget.textContent)
    }

    return (
      <div className="inputcomponent">
        <div className="inputcomponent__textarea" 
             contentEditable="true"
             onInput={onInputChange}>
        </div>
      </div>
    );
  }

  export default InputComponent