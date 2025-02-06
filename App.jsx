import './App.css'
import SimpleE_CommerceLogin from "./Login.jsx";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { Navbar} from "../Dashboard.jsx";
function App() {

  return (
      <Router>
          <Routes>
              <Route path="/" element = {<SimpleE_CommerceLogin/>}/>
              <Route path="/E_CommerceDashboard" element = {<Navbar/>}/>
          </Routes>
      </Router>
  );
}

export default App
