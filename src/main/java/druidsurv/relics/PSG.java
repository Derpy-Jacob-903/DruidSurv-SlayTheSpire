package druidsurv.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import druidsurv.CharacterFile;
import druidsurv.cards.colorless.Wolf;
import druidsurv.powers.ManaShieldPower;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

public class PSG extends AbstractEasyRelic {
    public static final String ID = makeID("PSG");
    private boolean activated;

    public PSG() {
        super(ID, RelicTier.COMMON, LandingSound.MAGICAL, CharacterFile.Enums.DRUIDSURV_COLOR);
    }

    public void atTurnStart() {
        atb(new ApplyPowerAction((AbstractCreature) AbstractDungeon.player, AbstractDungeon.player, new ManaShieldPower(AbstractDungeon.player, (int)(AbstractDungeon.player.maxHealth * 0.15))));
    }
}
