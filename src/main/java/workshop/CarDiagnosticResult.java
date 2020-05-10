package workshop;

import java.util.Objects;

public class CarDiagnosticResult {

    private String carId;

    private boolean diagnosticResult;

    public CarDiagnosticResult(String carId, boolean diagnosticResult) {
        this.carId = carId;
        this.diagnosticResult = diagnosticResult;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public boolean isDiagnosticResult() {
        return diagnosticResult;
    }

    public void setDiagnosticResult(boolean diagnosticResult) {
        this.diagnosticResult = diagnosticResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarDiagnosticResult that = (CarDiagnosticResult) o;
        return diagnosticResult == that.diagnosticResult &&
                Objects.equals(carId, that.carId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, diagnosticResult);
    }
}
