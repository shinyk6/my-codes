
import React, { useState } from "react";

export default function TravelForm({ onAdd }) {
  const [form, setForm] = useState({
    title: "", location: "", googleMapsUrl: "", startDate: "", endDate: "", description: "", imageUrl: ""
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const res = await fetch("http://localhost:8080/api/travels", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(form),
    });
    if (res.ok) {
      alert("등록 성공!");
      setForm({ title: "", location: "", googleMapsUrl: "", startDate: "", endDate: "", description: "", imageUrl: "" });
      onAdd();  // 새로고침용 콜백
    } else {
      alert("등록 실패");
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{ padding: "20px", borderBottom: "1px solid #ccc" }}>
      <h2>여행지 등록</h2>
      {["title", "location", "googleMapsUrl", "startDate", "endDate", "description", "imageUrl"].map((field) => (
        <div key={field} style={{ marginBottom: "10px" }}>  {/*배열의 개수만큼 만들어짐 -> map이기에 (map은 자신이 가지고 있는 개수 만큼 해당 명령을 수행) */}
          <label>
            {field}:{" "} 
            <input
              type="text"
              name={field}
              value={form[field]}
              onChange={handleChange}
              required
              style={{ width: "300px" }}
            />
          </label>
        </div>
      ))}
      <button type="submit">등록</button>
    </form>
  );
}
