import React from 'react'
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link
} from "react-router-dom";
import EditProduct from './pages/EditProduct';

import HomePage from './pages/HomePage';

function App() {
  return (
    <Router>
    <div>
      <Routes>
          <Route path='/' element={<HomePage/>} />
          <Route path='/editProduct' element={<EditProduct/>} />
      </Routes>
    </div>
  </Router>

  );
}

export default App;
