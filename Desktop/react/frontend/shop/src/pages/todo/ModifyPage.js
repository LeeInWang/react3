// 수정/삭제 컴포넌트
// function ModifyPage({tno}) {}
// const ModifyPage = ({ tno }) => {
//     return (
//         <div className="text-3xl font-extrabold text-center">
//             Todo 수정/삭제 페이지(Modify Page)
//         </div>
//     );
// }
// export default ModifyPage;

//# 2. 수정/삭제 처리 후 이동
// import { useNavigate } from "react-router-dom";

// const ModifyPage = ({ tno }) => {

//     const navigate = useNavigate()
//     // 조회화면으로 이동
//     const moveToRead = () => {
//         navigate({ pathname: `/todo/read/${tno}` })
//     }

//     // 목록(리스트) 화면으로 이동
//     const moveToList = () => {
//         navigate({ pathname: `/todo/list` })
//     }

//     return ( 
//         <div className="text-3xl font-extrabold text-center">
//             Todo 수정/삭제 페이지(Modify Page)
//         </div>
//     );
// }
// export default ModifyPage;

//#3. ModifyComponent를 import
//   일관성 있는 개발을 위해 버튼들을 ModifyComponent에서 처리하도록 설정
import { useParams } from "react-router-dom";
import ModifyComponent from "../../components/todo/ModifyComponent";

const ModifyPage = () => {

    const {tno} = useParams()
  
    return ( 
    <div className="p-4 w-full bg-indigo-300">
      <div className="text-3xl font-extrabold text-slate-950 text-center">
         Todo 변경 페이지(Modify Page)       
      </div>   
      <ModifyComponent tno={tno}/>
  
    </div>
    );
}
export default ModifyPage;