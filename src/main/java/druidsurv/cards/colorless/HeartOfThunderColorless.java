package druidsurv.cards.colorless;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Lightning;
import druidsurv.cards.AbstractPowerCostCard;

import static druidsurv.ModFile.makeID;

public class HeartOfThunderColorless extends AbstractPowerCostCard {
    public final static String ID = makeID("HeartThunderC");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public HeartOfThunderColorless() {
        super(ID, 2, CardType.ATTACK, CardRarity.BASIC, CardTarget.ALL_ENEMY, "HeartOfThunder");
        baseDamage = 4;
        this.showEvokeValue = true;
        this.showEvokeOrbCount = 1;
        baseMagicNumber = magicNumber = 1;
        isMultiDamage = true;
        setOrbTexture("druidsurvResources/images/512/bloontonium.png", "druidsurvResources/images/1024/bloontonium.png");
        //setBackgroundTexture("druidsurvResources/images/512/hero_attack.png", "druidsurvResources/images/1024/hero_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        allDmg(AbstractGameAction.AttackEffect.LIGHTNING);
        for (int i = 0; i < this.magicNumber; i++) {
            addToBot((AbstractGameAction)new ChannelAction((AbstractOrb)new Lightning()));
        }
    }

    @Override
    public void upp() {
        upgradeBaseCost(1);
    }
}