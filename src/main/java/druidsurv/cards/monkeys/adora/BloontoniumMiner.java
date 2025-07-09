package druidsurv.cards.monkeys.adora;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.BloontoniumPower;
import druidsurv.orbs.BloontoniumOrb;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

public class BloontoniumMiner extends AbstractEasyCard {
    public final static String ID = makeID("BloontoniumMiner");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public BloontoniumMiner() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.SELF_AND_ENEMY, CharacterFile.Enums.ADORA_COLOR, "NoArt");
        baseDamage = 2;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.setCardBack(cardSubType.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new ApplyPowerAction(p, p, new BloontoniumPower(p, 1), 1));
        atb(new ChannelAction(new BloontoniumOrb()));
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_LIGHT);
    }

    @Override
    public void upp() {
        upgradeDamage(6);
    }
}