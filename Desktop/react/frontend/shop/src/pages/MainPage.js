//#1. React-Roucter의 동작을 확인
// function MainPage(){
//     return(

//     );
// }


//#2.  메인페이지 이동
// const MainPage = () =>{
//     return(
//         <div className="text-center text-4xl text-emerald-300 font-extrabold">
//            <h2>Main Page(홈 페이지)</h2>
          
//         </div>
//     );
// }
// export default MainPage;

//#3. link //<Link> : 리액트 내부에서 해당 컴포넌트만 처리,  링크 처리
//  <a href=""></a> : 페이지를 새롭게 불러오는 개념  
//  <Link> :리액트 내부에서 해당 컴포넌트만 처리
//     import { Link } from "react-router-dom";

//     const MainPage = () => {
//     return (
//         <div>
//             <div className="flex">
//                 <Link to={"/about"}>About으로 이동</Link>
//             </div>
//             <div className="text-4xl text-center font-bold">
//                 <h2>Main Page</h2>
//             </div>

//         </div>
//     );
// }

// export default MainPage;

//#4. BasicLayout 적용
import BasicLayout from "../layouts/BasicLayout";

const MainPage = () => {
    return(
        <BasicLayout>
            <div className="text-3xl">MainPage</div>
        </BasicLayout>
    );
}
export default MainPage;