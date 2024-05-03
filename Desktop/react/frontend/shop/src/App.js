// import logo from './logo.svg';
// import './App.css';

// function App(props) {

//   return (

//     <div className="text-6xl text-red-600 font-bold underline text-center">
     
//      Hello react world!!;
    
//     </div>
  

//   );

// }

import {RouterProvider} from "react-router-dom";
import root from "./router/root";

function App() {
  return (
    <RouterProvider router={root}/>
  );
}


export default App;
