package druidsurv.cards;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

public class SupplyDrop extends AbstractEasyCard {
    public final static String ID = makeID("SupplyDrop");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public SupplyDrop() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseMagicNumber = 2;
        setBackgroundTexture("druidsurvResources/images/512/power_skill.png", "druidsurvResources/images/1024/power_skill.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {

        atb(new DrawCardAction(magicNumber));
    }

    @Override
    public void upp() {
        upgradeBaseCost(0);
    }
}