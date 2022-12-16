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
    protected final DcMotor slideMotor;
    // Height of each junction. This array is ordered ground -> low -> medium -> high junction.
    private final int[] junctionHeights = {20, -2400, -4200, -5100}; //TODO ADJUST VALUES

    // Map DC motor variable to driver hub
    public SlideCore (HardwareMap hardwareMap) {
        slideMotor = hardwareMap.get(DcMotor.class, "slide_motor");
    }


    /* Moves the slide to the height of a junction. Input options for junctionType are ground, low, medium, and high.*/
    public void moveToJunction(final String junctionType) {
        switch(junctionType.toUpperCase()) {
            case "GROUND": //move to ground in arena
                slideMotor.setTargetPosition(junctionHeights[0] - slideMotor.getCurrentPosition());
                return;
            case "LOW": //move to low junction
                slideMotor.setTargetPosition(junctionHeights[1] - slideMotor.getCurrentPosition());
                return;
            case "MEDIUM": //move to medium junction
                slideMotor.setTargetPosition(junctionHeights[2] - slideMotor.getCurrentPosition());
                return;
            case "HIGH": //move to high junction
                slideMotor.setTargetPosition(junctionHeights[3] - slideMotor.getCurrentPosition());
        }
        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideMotor.setPower(0.7);
    }

    /* Changes the height of the slide up by 'conesMoved' cones.
    * If conesMoves is negative, the slide moves down by the specified cone amount. */
    public void adjustHeight(final int conesMoved) {
        // Height that needs to be moved to move to the next cone in a cone stack
        //TODO ADJUST VALUE
        int coneHeight = -260;
        if (slideMotor.getCurrentPosition() - conesMoved * coneHeight > -5100 && slideMotor.getCurrentPosition() - conesMoved * coneHeight > 20) {
            slideMotor.setTargetPosition(slideMotor.getCurrentPosition() - conesMoved * coneHeight);
            slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            slideMotor.setPower(0.7);
        }
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("Slide Y", slideMotor.getCurrentPosition());
    }

}
