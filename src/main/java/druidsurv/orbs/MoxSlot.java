package druidsurv.orbs;

import basemod.AutoAdd;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.defect.EvokeOrbAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.OrbStrings;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.EmptyOrbSlot;
import druidsurv.orbs.mox.MoxOrb;

import static druidsurv.util.Wiz.att;

@AutoAdd.Ignore
public class MoxSlot extends AbstractOrb {
    public static final String ORB_ID = "EmptyMox";
    private static final OrbStrings orbString;
    public static final String[] DESC;

    public MoxSlot(float x, float y) {
        this.angle = MathUtils.random(360.0F);
        this.ID = "EmptyMox";
        this.name = orbString.NAME;
        this.evokeAmount = 0;
        this.cX = x;
        this.cY = y;
        this.updateDescription();
        this.channelAnimTimer = 0.5F;
    }

    public MoxSlot() {
        this.angle = MathUtils.random(360.0F);
        this.name = orbString.NAME;
        this.evokeAmount = 0;
        this.cX = AbstractDungeon.player.drawX + AbstractDungeon.player.hb_x;
        this.cY = AbstractDungeon.player.drawY + AbstractDungeon.player.hb_y + AbstractDungeon.player.hb_h / 2.0F;
        this.updateDescription();
    }

    public void updateDescription() {
        this.description = DESC[0];
    }

    public void onEvoke() {
        boolean usedOrbSlot = false;
        for (int i = 0; i < AbstractDungeon.player.orbs.size(); i++) {
            if (!(AbstractDungeon.player.orbs.get(i) instanceof MoxOrb) || !(AbstractDungeon.player.orbs.get(i) instanceof MoxSlot) || !(AbstractDungeon.player.orbs.get(i) instanceof EmptyOrbSlot))
            {
                if (!usedOrbSlot) { usedOrbSlot = true; }
                else { att(new EvokeOrbAction(1)); }
            }
        }
    }

    public void updateAnimation() {
        super.updateAnimation();
        this.angle += Gdx.graphics.getDeltaTime() * 10.0F;
    }

    public void render(SpriteBatch sb) {
        sb.setColor(this.c);
        sb.draw(ImageMaster.ORB_SLOT_2, this.cX - 48.0F - this.bobEffect.y / 8.0F, this.cY - 48.0F + this.bobEffect.y / 8.0F, 48.0F, 48.0F, 96.0F, 96.0F, this.scale, this.scale, 0.0F, 0, 0, 96, 96, false, false);
        sb.draw(ImageMaster.ORB_SLOT_1, this.cX - 48.0F + this.bobEffect.y / 8.0F, this.cY - 48.0F - this.bobEffect.y / 8.0F, 48.0F, 48.0F, 96.0F, 96.0F, this.scale, this.scale, this.angle, 0, 0, 96, 96, false, false);
        this.renderText(sb);
        this.hb.render(sb);
    }

    public AbstractOrb makeCopy() {
        return new MoxSlot();
    }

    public void playChannelSFX() {
    }

    static {
        orbString = CardCrawlGame.languagePack.getOrbString("Empty");
        DESC = orbString.DESCRIPTION;
    }
}
