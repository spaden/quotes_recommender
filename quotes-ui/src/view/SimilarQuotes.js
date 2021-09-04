import './styles/SimilarQuotes.scss'
import InputComponent from '../components/inputcomponent/inputComponent'
import { SHOW_PREDICTED_MODAL } from '../store/similarPred'
import { useSelector, useDispatch } from 'react-redux'

function SimilarQuotes(props) {
    
    const dispatch = useDispatch()

    const showModal = () => {
      dispatch(SHOW_PREDICTED_MODAL())
    }

    return (
      <div className="similarquotes">
        <InputComponent/>
        <br></br>
        <button onClick={showModal}>Test Modal</button>
      </div>
    );
  }

  export default SimilarQuotes