set PROJECT_DIR=%cd%
set RESULTS_DIR=%PROJECT_DIR%\allure-results
set TARGET_RESULTS_DIR=%PROJECT_DIR%\target\allure-results

if exist "%RESULTS_DIR%" (
    if not exist "%TARGET_RESULTS_DIR%" (
        mkdir "%TARGET_RESULTS_DIR%"
    )

    move "%RESULTS_DIR%\*" "%TARGET_RESULTS_DIR%\"
    rmdir /s /q "%RESULTS_DIR%"
) else (
    echo No allure-results directory found.
)

mvn allure:report

pause