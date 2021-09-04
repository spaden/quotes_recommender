import './styles/SimilarQuotes.scss'
import InputComponent from '../components/inputcomponent/inputComponent'
import { SHOW_PREDICTED_MODAL } from '../store/similarPred'
import { useSelector, useDispatch } from 'react-redux'
import Button from '../components/button/button'

function SimilarQuotes(props) {
    
    const dispatch = useDispatch()

    const showModal = () => {
      dispatch(SHOW_PREDICTED_MODAL())
    }

    return (
      <div className="similarquotes">
          <div className="container-fluid">
              <div className="row justify-content-center">
                  <div className="col col-sm-12 col-md-10 col-lg-7">
                      <InputComponent/>
                      <div className="similarquotes__predictbutton">
                          <Button name="Get Similar quotes"
                                  onClick={showModal}></Button>
                      </div>
                  </div>
              </div>
          </div>
      </div>
    );
  }

  export default SimilarQuotes