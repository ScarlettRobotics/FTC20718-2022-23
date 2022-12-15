package org.firstinspires.ftc.teamcode.Core;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public abstract class UpperSystemManager extends OpMode {
    // Initialize claw and slide classes
    protected DualMotorDrive drive;
    protected ClawCore claw;
    protected SlideCore slide;
    // Stores previous states of listed buttons
    private boolean pgamepad_dpad_up = false;
    private boolean pgamepad_dpad_down = false;

    @Override
    public void init() {
        // Define classes
        drive = new DualMotorDrive(hardwareMap);
        claw = new ClawCore(hardwareMap);
        slide = new SlideCore(hardwareMap);
        // Telemetry
        telemetry.addData("STATUS: ", "Initialized"); // the FTC equivalent to println()
        telemetry.addData("FTC Team #", "20718");
    }


    /* Moves the slide based on gamepad presses */
    protected void updateSlide(final int playerOp) {
        switch (playerOp) {
            case 1:
                // Set to specific set heights
                if (gamepad1.a) slide.moveToJunction("ground");
                if (gamepad1.x) slide.moveToJunction("low");
                if (gamepad1.y) slide.moveToJunction("medium");
                if (gamepad1.b) slide.moveToJunction("high");
                // Move by a cone height
                if (gamepad1.dpad_up && !pgamepad_dpad_up) slide.adjustHeight(1);
                if (gamepad1.dpad_down && !pgamepad_dpad_down) slide.adjustHeight(-1);
                // Update previous gamepad presses
                pgamepad_dpad_up = gamepad1.dpad_up;
                pgamepad_dpad_down = gamepad1.dpad_down;
                break;
            case 2:
                // Set to specific set heights
                if (gamepad2.a) slide.moveToJunction("ground");
                if (gamepad2.x) slide.moveToJunction("low");
                if (gamepad2.y) slide.moveToJunction("medium");
                if (gamepad2.b) slide.moveToJunction("high");
                // Move by a cone height
                if (gamepad2.dpad_up && !pgamepad_dpad_up) slide.adjustHeight(1);
                if (gamepad2.dpad_down && !pgamepad_dpad_down) slide.adjustHeight(-1);
                // Update previous gamepad presses
                pgamepad_dpad_up = gamepad2.dpad_up;
                pgamepad_dpad_down = gamepad2.dpad_down;
                break;
        }
        slide.telemetry(telemetry);
    }

    /* Updates claw position based on gamepad presses */
    protected void updateClaw(final int playerOp) {
        switch (playerOp) {
            case 1:
                // Open/close claw if A/B is pressed (respectively)
                if (gamepad1.left_bumper) {
                    claw.clawOpen();
                } else if (gamepad1.right_bumper) {
                    claw.clawClose();
                }
            case 2:
                // Open/close claw if A/B is pressed (respectively)
                if (gamepad2.left_bumper) {
                    claw.clawOpen();
                } else if (gamepad2.right_bumper) {
                    claw.clawClose();
                }
        }
        claw.telemetry(telemetry);
    }
}
