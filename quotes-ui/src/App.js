import { Route } from 'react-router-dom'
import './App.css'
import Home from './view/Home'
import SimilarQuotes from './view/SimilarQuotes'

function App() {
  
  return (
    <div className="container-fluid justify-content-center">
        <Route path="/home">
          <Home/>
        </Route>
        <Route path="/similarquotes">
          <SimilarQuotes/>
        </Route>
    </div>
  );
}

export default App;
