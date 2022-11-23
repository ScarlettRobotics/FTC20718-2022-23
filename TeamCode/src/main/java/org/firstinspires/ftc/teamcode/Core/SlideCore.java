package org.firstinspires.ftc.teamcode.Core;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * SlideCore
 * Handles inputs to the slide mechanism's motor.
 */
public class SlideCore {
    // Initialize DC motor variable
    private DcMotor slideMotor = null;
<<<<<<< HEAD

    public SlideCore(HardwareMap hardwareMap) {
=======
    // Map DC motor variable to driver hub
    public SlideCore (HardwareMap hardwareMap) {
>>>>>>> ArcadeDrive-edits
        slideMotor = hardwareMap.get(DcMotor.class, "slide_motor");
        slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slideMotor.setDirection(DcMotor.Direction.REVERSE);
    }


    /**
     * setSlidePower
     * <p>
     * Sets the power to the motor. Ensures it is between -1, and 1. Although this is made somewhat redundant
     * if one were to use hard-coded literals for the button maps (i.e if pushed then set value to 1); it
     * makes it easy to implement if it were attached to an analog input.
     *
     * @param powerSlide Raw input power
     */
<<<<<<< HEAD
    public void setSlidePower(double slidePower) {
=======
    public void setSlidePower(double powerSlide){
>>>>>>> ArcadeDrive-edits
        double largest = 0.5;

        // Takes the largest value out of 0.5 and powerSlide
        largest = Math.max(largest, Math.abs(powerSlide));
        slideMotor.setPower((powerSlide / largest));
    }

    public void telemetry(Telemetry telemetry, double slidePower) {
        telemetry.addData("Slide Y:", slidePower);
    }

}
