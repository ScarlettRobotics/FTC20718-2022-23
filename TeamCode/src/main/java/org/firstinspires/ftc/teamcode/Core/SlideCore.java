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
    private final int[] junctionHeights = {0, 20, 40, 60}; //TODO ADJUST VALUES
    // Height that needs to be moved to move to the next cone in a cone stack
    private final int coneHeight = 3; //TODO ADJUST VALUE

    // Map DC motor variable to driver hub
    public SlideCore (HardwareMap hardwareMap) {
        slideMotor = hardwareMap.get(DcMotor.class, "slide_motor");
        slideMotor.setTargetPosition(1);
        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideMotor.setDirection(DcMotor.Direction.REVERSE);
    }


    /* Moves the slide to the height of a junction. Input options for junctionType are ground, low, medium, and high.*/
    public void moveToJunction(final String junctionType) {
        switch(junctionType.toLowerCase()) {
            case "ground":
                adjustHeight((junctionHeights[0] - slideMotor.getCurrentPosition()) / coneHeight + 1);
                return;
            case "low":
                adjustHeight((junctionHeights[1] - slideMotor.getCurrentPosition()) / coneHeight + 1);
                return;
            case "medium":
                adjustHeight((junctionHeights[2] - slideMotor.getCurrentPosition()) / coneHeight + 1);
                return;
            case "high":
                adjustHeight((junctionHeights[3] - slideMotor.getCurrentPosition()) / coneHeight + 1);
        }
    }

    /* Changes the height of the slide up by 'conesMoved' cones.
    * If conesMoves is negative, the slide moves down by the specified cone amount. */
    public void adjustHeight(final int conesMoved) {
        slideMotor.setTargetPosition(conesMoved * coneHeight);
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("Slide Y", slideMotor.getCurrentPosition());
    }

}
