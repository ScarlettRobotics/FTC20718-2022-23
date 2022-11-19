package org.firstinspires.ftc.teamcode.Core;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/** SlideCore
 *  Handles inputs to the slide mechanism's motor.
 */
public class SlideCore {
    private DcMotor slideMotor = null;

    public SlideCore (HardwareMap hardwareMap) {
        slideMotor = hardwareMap.get(DcMotor.class, "slide_motor");
        slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slideMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    /** setSlidePower
     *
     *  Sets the power to the motor. Ensures it is between -1, and 1. Although this is made somewhat redundant
     *  if one were to use hard-coded literals for the button maps (i.e if pushed then set value to 1); it
     *  makes it easy to implement if it were attached to an analog input.
     *
     * @param slidePower Raw input power
     */
    public void setSlidePower(double slidePower){
        double largest = 0.5;
        largest = Math.max(largest, Math.abs(slidePower));
        slideMotor.setPower((slidePower / largest));
    }

}
