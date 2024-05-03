// 등록(추가) - 새로운 Todo를 등록할 수 있는 페이지 컴포넌트 
// const AddPage = () => {


//     return (
//         <div className="text-3xl font-extrabold text-center text-orange-600">
//             Todo 추가 페이지(Add Page Component)
//         </div>
//     );
// }

// export default AddPage;

//#2. 등록 컴포넌트 처리

import AddComponent from "../../components/todo/AddComponent";

const AddPage = () => {


    return (
        <div className="text-xl p-4 w-full bg-slate-400 text-center">
            <div className="text-3xl font-extrabold text-white">
                Todo 추가 페이지(Add Page Component)
            </div>
            <AddComponent />
        </div>
    );
}

export default AddPage;