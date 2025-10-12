<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSON 데이터 시각화</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        
        body {
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 2rem;
        }
        
        .container {
            width: 100%;
            max-width: 900px;
            margin: 0 auto;
        }
        
        header {
            text-align: center;
            margin-bottom: 2.5rem;
            color: #2c3e50;
        }
        
        h1 {
            font-size: 2.5rem;
            margin-bottom: 0.5rem;
            text-shadow: 1px 1px 3px rgba(0,0,0,0.1);
        }
        
        .subtitle {
            color: #7f8c8d;
            font-size: 1.1rem;
        }
        
        .card {
            background: white;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            padding: 2rem;
            margin-bottom: 2rem;
            transition: transform 0.3s ease;
        }
        
        .card:hover {
            transform: translateY(-5px);
        }
        
        .card-title {
            color: #3498db;
            margin-bottom: 1.5rem;
            padding-bottom: 0.5rem;
            border-bottom: 2px solid #f1f1f1;
            font-size: 1.5rem;
        }
        
        .info-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 1.5rem;
        }
        
        .info-item {
            background: #f8f9fa;
            padding: 1.2rem;
            border-radius: 8px;
            border-left: 4px solid #3498db;
        }
        
        .info-label {
            font-weight: 600;
            color: #7f8c8d;
            font-size: 0.9rem;
            margin-bottom: 0.5rem;
        }
        
        .info-value {
            font-size: 1.2rem;
            color: #2c3e50;
            font-weight: 500;
        }
        
        .code-container {
            background: #2c3e50;
            color: #ecf0f1;
            padding: 1.5rem;
            border-radius: 8px;
            font-family: 'Consolas', 'Monaco', monospace;
            overflow-x: auto;
            margin-top: 1.5rem;
        }
        
        .property {
            color: #e74c3c;
        }
        
        .value {
            color: #2ecc71;
        }
        
        .console-output {
            background: #1e272e;
            color: #f5f6fa;
            padding: 1.5rem;
            border-radius: 8px;
            font-family: 'Consolas', 'Monaco', monospace;
            margin-top: 1.5rem;
        }
        
        .console-title {
            color: #ffa801;
            margin-bottom: 1rem;
            font-weight: 600;
        }
        
        .console-line {
            margin-bottom: 0.5rem;
            color: #d2dae2;
        }
        
        .btn {
            background: #3498db;
            color: white;
            border: none;
            padding: 0.8rem 1.5rem;
            border-radius: 6px;
            cursor: pointer;
            font-size: 1rem;
            font-weight: 500;
            transition: background 0.3s;
            margin-top: 1rem;
        }
        
        .btn:hover {
            background: #2980b9;
        }
        
        footer {
            text-align: center;
            margin-top: 2rem;
            color: #7f8c8d;
            font-size: 0.9rem;
        }
        
        @media (max-width: 768px) {
            .info-grid {
                grid-template-columns: 1fr;
            }
            
            h1 {
                font-size: 2rem;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <header>
            <h1>JSON 데이터 시각화</h1>
            <p class="subtitle">자바스크립트 객체를 시각적으로 표현하고 콘솔 출력을 확인해보세요</p>
        </header>
        
        <div class="card">
            <h2 class="card-title">자동차 정보</h2>
            
            <div class="info-grid">
                <div class="info-item">
                    <div class="info-label">브랜드</div>
                    <div class="info-value" id="brand-value">소나타</div>
                </div>
                
                <div class="info-item">
                    <div class="info-label">제조연도</div>
                    <div class="info-value" id="year-value">2020</div>
                </div>
                
                <div class="info-item">
                    <div class="info-label">색상</div>
                    <div class="info-value" id="color-value">white</div>
                </div>
            </div>
            
            <div class="code-container">
                <pre><code>const car = {
    <span class="property">"brand"</span>: <span class="value">"소나타"</span>,
    <span class="property">"year"</span>: <span class="value">2020</span>,
    <span class="property">"color"</span>: <span class="value">"white"</span>
};</code></pre>
            </div>
            
            <button class="btn" onclick="showConsoleOutput()">콘솔 출력 보기</button>
            
            <div class="console-output" id="console-output" style="display: none;">
                <div class="console-title">콘솔 출력:</div>
                <div class="console-line" id="console-line1"></div>
                <div class="console-line" id="console-line2"></div>
                <div class="console-line" id="console-line3"></div>
            </div>
        </div>
        
        <footer>
            <p>JSON 데이터를 시각적으로 표현하는 예제 페이지</p>
        </footer>
    </div>

    <script>
        // JSON 형태의 데이터를 자바스크립트 객체로 선언
        const car = {
            "brand": "소나타",
            "year": 2020,
            "color": "white"
        };
        
        // 페이지 로드 시 정보 표시
        document.addEventListener('DOMContentLoaded', function() {
            document.getElementById('brand-value').textContent = car.brand;
            document.getElementById('year-value').textContent = car.year;
            document.getElementById('color-value').textContent = car.color;
        });
        
        // 콘솔 출력 함수
        function showConsoleOutput() {
            const consoleOutput = document.getElementById('console-output');
            consoleOutput.style.display = 'block';
            
            document.getElementById('console-line1').textContent = `> car.brand: "${car.brand}"`;
            document.getElementById('console-line2').textContent = `> car.year: ${car.year}`;
            document.getElementById('console-line3').textContent = `> car.color: "${car.color}"`;
            
            // 실제 콘솔에도 출력
            console.log(car.brand);
            console.log(car.year);
            console.log(car.color);
        }
    </script>
</body>
</html>