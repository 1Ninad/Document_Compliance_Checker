import React, { useState } from "react";
import axios from "axios";

const FileUpload = () => {
    const [file, setFile] = useState(null);
    const [report, setReport] = useState(null);
    const [error, setError] = useState("");

    const handleFileChange = (event) => {
        setFile(event.target.files[0]);
        setReport(null);
        setError("");
    };

    const handleUpload = async () => {
        if (!file) {
            alert("Please select a file first!");
            return;
        }

        const formData = new FormData();
        formData.append("file", file);

        try {
            const response = await axios.post("http://localhost:8080/api/pdf/upload", formData, {
                headers: { "Content-Type": "multipart/form-data" },
            });

            if (response.status === 200) {
                setReport(response.data);
            } else {
                setError("Unexpected server response.");
            }
        } catch (err) {
            console.error("Upload Error:", err.response);
            setError(`Upload failed: ${err.response?.data?.message || "Server error"}`);
        }
    };

    return (
        <div className="max-w-4xl mx-auto p-6 text-black">
            <h2 className="text-2xl font-bold text-center mb-4">Upload PDF for Compliance Check</h2>
            <div className="flex flex-col items-center space-y-4">
                <input 
                    type="file" 
                    accept="application/pdf" 
                    onChange={handleFileChange} 
                    className="file:py-2 file:px-4 file:border file:border-gray-300 file:rounded-md file:bg-gray-200 file:hover:bg-gray-300"
                />
                <button 
                    onClick={handleUpload} 
                    className="bg-blue-600 text-white px-6 py-2 rounded-md hover:bg-blue-700"
                >
                    Upload
                </button>
            </div>

            {error && <p className="text-red-600 mt-4 text-center">{error}</p>}

            {report && (
                <div className="mt-6 p-4 border border-gray-300 rounded-md bg-gray-100">
                    <h3 className="text-lg font-semibold">Compliance Report</h3>
                    <p><strong>File Name:</strong> {report.fileName}</p>
                    {report.errors.length > 0 ? (
                        <ul className="text-red-600 mt-2">
                            {report.errors.map((error, index) => (
                                <li key={index}>{error}</li>
                            ))}
                        </ul>
                    ) : (
                        <p className="text-green-600 mt-2">✅ No compliance errors found!</p>
                    )}
                </div>
            )}
        </div>
    );
};

export default FileUpload;
