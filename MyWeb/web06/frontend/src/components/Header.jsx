import React from "react";
export default function Header() {
  return (
    <nav className="navbar">
      {/*  프로젝트\public  에서 이미지를 찾음 */}
      {/* <img src="/images/globe.png" alt="지구본 아이콘" className="nav--icon" /> */}
      <h1 className="nav--title">나의 여행 일기</h1>
    </nav>
  );
}
