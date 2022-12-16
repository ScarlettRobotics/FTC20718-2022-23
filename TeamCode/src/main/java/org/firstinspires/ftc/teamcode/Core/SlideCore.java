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
    private final int[] junctionHeights = {-60, -2200, -4000, -5200}; //TODO ADJUST VALUES
    // Height that needs to be moved to move to the next cone in a cone stack
    private final int coneHeight = -270; //TODO ADJUST VALUE

    // Map DC motor variable to driver hub
    public SlideCore (HardwareMap hardwareMap) {
        slideMotor = hardwareMap.get(DcMotor.class, "slide_motor");
    }


    /* Moves the slide to the height of a junction. Input options for junctionType are ground, low, medium, and high.*/
    public void moveToJunction(final String junctionType) {
        switch(junctionType.toUpperCase()) {
            case "GROUND": //move to ground in arena
                adjustHeight((junctionHeights[0] - slideMotor.getCurrentPosition()));
                return;
            case "LOW": //move to low junction
                adjustHeight((junctionHeights[1] - slideMotor.getCurrentPosition()) / coneHeight);
                return;
            case "MEDIUM": //move to medium junction
                adjustHeight((junctionHeights[2] - slideMotor.getCurrentPosition()) / coneHeight);
                return;
            case "HIGH": //move to high junction
                adjustHeight((junctionHeights[3] - slideMotor.getCurrentPosition()) / coneHeight);
        }
    }

    /* Changes the height of the slide up by 'conesMoved' cones.
    * If conesMoves is negative, the slide moves down by the specified cone amount. */
    public void adjustHeight(final int conesMoved) {
        slideMotor.setTargetPosition(slideMotor.getCurrentPosition() - conesMoved * coneHeight);
        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideMotor.setPower(1);
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("Slide Y", slideMotor.getCurrentPosition());
    }

}
