package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Lightning;

import static druidsurv.ModFile.makeID;

public class HeartOfThunder extends AbstractEasyCard {
    public final static String ID = makeID("HeartThunder");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public HeartOfThunder() {
        super(ID, 2, CardType.ATTACK, CardRarity.BASIC, CardTarget.ENEMY);
        baseDamage = 5;
        this.showEvokeValue = true;
        this.showEvokeOrbCount = 1;
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        dmg(m, AbstractGameAction.AttackEffect.NONE);
        for (int i = 0; i < this.magicNumber; i++) {
            addToBot((AbstractGameAction)new ChannelAction((AbstractOrb)new Lightning()));
        }
    }

    @Override
    public void upp() {
        upgradeBaseCost(1);
    }
}