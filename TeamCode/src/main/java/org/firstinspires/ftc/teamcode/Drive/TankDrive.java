package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Core.ClawCore;
import org.firstinspires.ftc.teamcode.Core.DualMotorDrive;
import org.firstinspires.ftc.teamcode.Core.SlideCore;


/** TankDrive
 *  Tank drive. left stick controls left motor, right stick controls right motor.
 */
@TeleOp(name="TankDrive",group="auto")
public class TankDrive extends OpMode {
    // Init classes
    DualMotorDrive drive = new DualMotorDrive();
    ClawCore claw = new ClawCore();
    SlideCore slide = new SlideCore();

    @Override
    public void init() {
        drive.init(hardwareMap);
        telemetry.addData("DRIVE MODE: ", "TankDrive 1 Player");
        telemetry.addData("STATUS: ", "Initialized");
        telemetry.addData("FTC Team #", "20718");
        telemetry.update();
    }

    @Override
    public void loop() {
        telemetry.addData("STATUS: ", "Running");
        telemetry.update();
        //DriveTrain
        double left = -gamepad1.left_stick_y;
        double right = gamepad1.right_stick_y;
        telemetry.addData("Left Stick:", left);
        telemetry.addData("Right Stick:", right);
        drive.setPowers(left, right);

        // Toggle claw on A press
        if (gamepad1.a) {
            claw.clawToggle();
        }

        // TODO: set slide to move up and down along specific increments instead of linearly
        // Move slide based on LT and RT press
        double slidePower = (-gamepad1.left_trigger + gamepad1.right_trigger);
        telemetry.addData("Slide Y:",slidePower);

        slide.setSlidePower(slidePower);

    }
}
