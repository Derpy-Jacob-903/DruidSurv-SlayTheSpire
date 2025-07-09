package druidsurv.orbs.mox;

import com.evacipated.cardcrawl.mod.stslib.actions.defect.EvokeSpecificOrbAction;

import static druidsurv.ModFile.makeImagePath;
import static druidsurv.util.TexLoader.getTexture;
import static druidsurv.util.Wiz.atb;
import static druidsurv.util.Wiz.att;

public class BrittleMox extends MoxOrb {

    public BrittleMox(int greenMox, int rubyMox, int blueMox, int voidMox) {
        this.ID = "druidsurv:MoxOrbBrittle";
        this.img = getTexture(makeImagePath("orbs/mox1.png"));
        this.GreenAmount = greenMox;
        this.RubyAmount = rubyMox;
        this.BlueAmount = blueMox;
        this.RainAmount = voidMox;
        //applyFocus();
        updateDescription();
        this.channelAnimTimer = 0.5F;
    }

    public BrittleMox(int greenMox, int rubyMox, int blueMox ) {
        this.ID = "druidsurv:MoxOrbBrittle";
        this.img = getTexture(makeImagePath("orbs/mox1.png"));
        this.GreenAmount = greenMox;
        this.RubyAmount = rubyMox;
        this.BlueAmount = blueMox;
        //applyFocus();
        updateDescription();
        this.channelAnimTimer = 0.5F;
    }

    public BrittleMox() {
        this.ID = "druidsurv:MoxOrbBrittle";
        this.img = getTexture(makeImagePath("orbs/mox1.png"));
        //applyFocus();
        updateDescription();
        this.channelAnimTimer = 0.5F;
    }

    @Override
    public void onEndOfTurn() {
        super.onEndOfTurn();
        atb(new EvokeSpecificOrbAction(this));
    }
}
