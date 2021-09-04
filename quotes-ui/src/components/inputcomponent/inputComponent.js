import { useState } from 'react';
import './inputComponentStyle.scss'
import LoaderComponent from '../loader/loaderComponent';
import { SHOW_PREDICTED_MODAL } from '../../store/similarPred'
import { useSelector, useDispatch } from 'react-redux'

function InputComponent(props) {
    const showPredictedModal = useSelector(state => state.mlPrediction.showPredictedModal)
    const dispatch = useDispatch()
    const placeholder = 'Get a similar quote by entering your favourite one here'
    const onInputChange = (e) => {
      // props.onChange(e.currentTarget.textContent)
    }

    const checkIfEmpty = (e) => {
      const textConent = e.currentTarget.textContent
      console.log(textConent)
      if (textConent === placeholder || textConent == '') {
        e.currentTarget.textContent = placeholder
      }
    }

    const checkIfPlaceholder = (e) => {
      const textContent = e.currentTarget.textContent
      if (textContent === placeholder) {
        e.currentTarget.textContent = ''
      }
    }

    const check = false
    const currentComponent = () => {
      if (check) {
        return (
          <div className="inputcomponent__spinnercomponent">
            <LoaderComponent/>
          </div>
        )
      }
    }

    const showModal = () => {
      dispatch(SHOW_PREDICTED_MODAL())
    }

    const predictedQuote = () => {
      return (
        <div className="inputcomponent__predictedQuote"
             contentEditable="false">
            <span className="inputcomponent__predictedQuote--close"
                  onClick={showModal}>
              X
            </span>
            <div className="inputcomponent__predictedQuote--quotetext">
                “Many of life’s failures are people who did not realize how close they were to success when they gave up.”
            </div>
        </div>
      )
    }

    return (
      <div className="inputcomponent">
        <div className={`inputcomponent__textarea 
                        ${check ? 'inputcomponent__textarea--fetching': ''}
                      `}
             contentEditable={!check}
             onInput={onInputChange}
             onClick={checkIfPlaceholder}
             onBlur={checkIfEmpty}>
             {showPredictedModal ? predictedQuote() : ''}
        </div>
        {currentComponent()}
      </div>
    );
  }

  export default InputComponent