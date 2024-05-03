// BasicLayout 컴포넌트는 화면 상단에는 공통적인 메뉴와 링크를 보여주고
// 아래쪽으로 각 페이지 컴포넌트를 출력하는 구조
//#1. children 속성 - 컴포넌트 내부에 다른 컴포넌트를 적용

// function BasicLayout({children}){}

// const BasicLayout = ({children}) => {
//   return ( 
//    <>    {/* 주석(Ctrl + /), <div> </div> */}
//     <header className="bg-teal-400 p-5">
//       <h1 className="text-2xl md:text-4xl">
//          Header
//       </h1>
//     </header>
//     <div className="bg-white my-5 w-full flex flex-col space-y-4 md:flex-row md:space-x-4 md:space-y-0">
//         <main className="bg-sky-300 md:w-2/3 lg:w-3/4 px-5 py-40">
//             {children}
//         </main>
//         <aside className="bg-green-300 md:w-1/3 lg:w-1/4 px-5 py-40">
//             <h1 className="text-2xl md:text-4xl">
//                 Sidebar
//             </h1>
//         </aside>

//      </div>
//     </>
//      );
//    }
// export default BasicLayout;

//#2. BasicMenu 적용  - 각 상단에 BasicMenu 컴포넌트를 추가해서 각 화면에 공통의 메뉴가 나오도록 구성
// import BasicMenu from "../components/menus/BasicMenu";

// const BasicLayout = ({children}) => {
//   return ( 
//    <>
//    {/* <BasicMenu></BasicMenu>   */}
//    <BasicMenu />
//     {/* 이 부분이 제거되고 <BasicMenu> 컴포넌트가 추가
//      <header className="bg-teal-400 p-5">
//         <h1 className="text-2xl md:text-4xl">
//            Header
//         </h1>
//      </header> */}
//     <div className="bg-white my-5 w-full flex flex-col space-y-4 md:flex-row
//     md:space-x-4 md:space-y-0">
//         <main className="bg-sky-300 md:w-2/3 lg:w-3/4 px-5 py-40">
//            <h1 className="text-2xl md:text-4xl"> {children} </h1> 
//         </main>
//         <aside className="bg-green-300 md:w-1/3 lg:w-1/4 px-5 py-40">
//             <h1 className="text-2xl md:text-4xl">
//                 Sidebar
//             </h1>
//         </aside>

//      </div>
//     </>
//      );
//    }
// export default BasicLayout;

//#3.  하위 경로 설정 관련 수정 - 패딩과 마진을 수정, 색상 수정
import BasicMenu from "../components/menus/BasicMenu";

const BasicLayout = ({children}) => {
  return ( 
   <>
   <BasicMenu />
    {/* 상단 여백 my-5(상/하 마진) md:space-x-1 : 왼쪽 여백 설정 */}
    <div className="bg-white w-full flex flex-col space-y-4 md:flex-row my-1 md:space-x-1 md:space-y-0">
        {/* py(위/아래 패딩)-40  --> py-5 */}
        <main className="bg-indigo-700 md:w-4/5 lg:w-3/4 px-5 py-20">
           <h1 className="text-2xl md:text-4xl text-white"> 
               {children}
           </h1> 
        </main>
        <aside className="bg-blue-500 md:w-1/5 lg:w-1/4 px-5 py-20">
            <h1 className="text-2xl md:text-4xl text-white">
                Sidebar
            </h1>
        </aside>

     </div>
    </>
     );
   }
export default BasicLayout;