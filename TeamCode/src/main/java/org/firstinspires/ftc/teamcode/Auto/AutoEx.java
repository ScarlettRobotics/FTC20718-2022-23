package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Core.ClawCore;
import org.firstinspires.ftc.teamcode.Core.DualMotorDrive;
import org.firstinspires.ftc.teamcode.Core.SlideCore;

@Autonomous(name = "ExampleAuto", group = "Auto")
public class AutoEx {

    DualMotorDrive drive = new DualMotorDrive();
    ClawCore claw = new ClawCore();
    SlideCore slide = new SlideCore();

    @Override
    public void runOpMode() {

    }
}
